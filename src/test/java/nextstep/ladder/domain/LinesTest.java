package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LinesTest {

    private final int countOfPerson = 4;

    @Test
    @DisplayName("팩토리 메소드 정상 작동")
    void of() {
        Lines lines = Lines.of(countOfPerson,
                asLine(true, false, true),
                asLine(false, true, false),
                asLine(true, false, false),
                asLine(false, true, false),
                asLine(true, false, true)
        );
        assertNotNull(lines);
    }

    @Test
    @DisplayName("팩토리 메소드 예외 발생 - countOfPerson")
    void of_validateSize() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                Lines.of(countOfPerson + 1,
                        asLine(true, false, true),
                        asLine(false, true, false),
                        asLine(true, false, false),
                        asLine(false, true, false),
                        asLine(true, false, true)
                )
        );
    }

    private static Line asLine(Boolean... points) {
        return Arrays.stream(points)
                .map(Point::of)
                .collect(collectingAndThen(toList(), Line::of));
    }
}
