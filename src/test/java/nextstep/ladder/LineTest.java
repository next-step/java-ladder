package nextstep.ladder;

import ladder.Line;
import ladder.PointStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LineTest {
    @Test
    void 오른쪽_왼쪽으로_이동() {
        PointStrategy strategy = new FixPointStrategy(List.of(false, true, false, false));
        Line line = new Line(5, strategy);
        Assertions.assertThat(line.move(1)).isEqualTo(2);
        Assertions.assertThat(line.move(2)).isEqualTo(1);
    }

    @Test
    void 마지막_Point_이동할수_없음() {
        PointStrategy strategy = new FixPointStrategy(List.of(false, true, false, false));
        Line line = new Line(5, strategy);
        Assertions.assertThat(line.canMoveRight(2)).isFalse();
    }

    @Test
    void 참가자수_보다_하나작다() {
        PointStrategy strategy = new FixPointStrategy(List.of(false, true, false, false, true, true));
        Line line = new Line(5, strategy);
        Assertions.assertThat(line.size()).isEqualTo(4);
    }
    @Test
    void 연속된_line_생성_불가() {
        PointStrategy strategy = new FixPointStrategy(List.of(true, true, true, true));
        Line line = new Line(5, strategy);
        // 연속된 가로줄이 무시되어 한 칸만 이동함
        Assertions.assertThat(line.move(0)).isEqualTo(1);
    }

}
