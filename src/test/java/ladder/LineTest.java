package ladder;

import ladder.domain.Direction;
import ladder.domain.Line;
import ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatCode;

public class LineTest {
    private static final Point point1 = new Point(1, Direction.RIGHT);
    private static final Point point2 = new Point(2, Direction.LEFT);

    @Test
    @DisplayName("가로라인 생성 테스트")
    void createLineTest(){
        assertThatCode(
                () -> new Line(1, Arrays.asList(point1, point2))
        ).doesNotThrowAnyException();
    }
}
