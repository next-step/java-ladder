package nextstep.ladder;

import ladder.Line;
import ladder.LineFactory;
import ladder.PointStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LineTest {
    @Test
    void 오른쪽_왼쪽으로_이동() {
        PointStrategy strategy = new FixPointStrategy(List.of(false, true, false, false));
        Line line = LineFactory.create(5, strategy);
        Assertions.assertThat(line.move(1)).isEqualTo(2);
        Assertions.assertThat(line.move(2)).isEqualTo(1);
    }

    @Test
    void 마지막_Point_이동할수_없음() {
        PointStrategy strategy = new FixPointStrategy(List.of(false, true, false, false));
        Line line = LineFactory.create(5, strategy);
        int movedIndex = line.move(4); // 마지막 인덱스
        Assertions.assertThat(movedIndex).isEqualTo(4);
    }

    @Test
    void 참가자수와_같은_수의_Point가_생성() {
        PointStrategy strategy = new FixPointStrategy(List.of(false, true, false, false, true, true));
        Line line = LineFactory.create(5, strategy);
        Assertions.assertThat(line.size()).isEqualTo(5);
    }
}
