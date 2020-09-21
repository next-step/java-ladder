package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LadderTest {

    private int height = 5;
    private int countOfPerson = 4;

    @Test
    @DisplayName("팩토리 메소드 정상 작동")
    void of() {
        assertNotNull(Ladder.of(height,
                asLine(true, false, true),
                asLine(false, true, false),
                asLine(true, false, false),
                asLine(false, true, false),
                asLine(true, false, true)
        ));
    }

    @Test
    @DisplayName("팩토리 메소드 예외 발생")
    void of_validate() {
        assertThatIllegalArgumentException().isThrownBy(() -> Ladder.of(height,
                asLine(true, false, true),
                asLine(false, true, false),
                asLine(true, false, false),
                asLine(false, true, false)
        ));
    }

    private static Line asLine(Boolean... points) {
        List<Point> pointList = Arrays.stream(points).map(Point::of).collect(Collectors.toList());
        return Line.of(pointList);
    }
}
