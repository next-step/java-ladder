package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static nextstep.ladder.TestUtil.asLine;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LadderTest {

    private final int height = 5;
    private final int countOfPerson = 4;

    @Test
    @DisplayName("팩토리 메소드 정상 작동")
    void of() {
        List<Line> lines = Arrays.asList(
                asLine(true, false, true),
                asLine(false, true, false),
                asLine(true, false, false),
                asLine(false, true, false),
                asLine(true, false, true)
        );

        assertNotNull(Ladder.of(height, countOfPerson, lines));
    }

    @Test
    @DisplayName("팩토리 메소드 예외 발생 - height")
    void of_validateHeight() {
        List<Line> lines = Arrays.asList(
                asLine(true, false, true),
                asLine(false, true, false),
                asLine(true, false, false),
                asLine(false, true, false)
        );

        assertThatIllegalArgumentException().isThrownBy(() ->
                Ladder.of(height, countOfPerson, lines)
        );
    }
}
