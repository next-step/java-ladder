package nextstep.ladder;

import ladder.Point;
import ladder.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LineTest {
    @Test
    void 오른쪽_왼쪽으로_이동() {
        Line line = new Line(List.of(
                new Point(false), new Point(true), new Point(false)
        ));
        Assertions.assertThat(line.move(1)).isEqualTo(2);
        Assertions.assertThat(line.move(2)).isEqualTo(1);
    }

    @Test
    void 마지막_Point_이동할수_없음() {
        Line line = new Line(List.of(
                new Point(false), new Point(true), new Point(false)
        ));
        Assertions.assertThat(line.canMoveRight(2)).isFalse();
    }
}
