package ladder.domain;

import ladder.fixture.TestLadderFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("플레이어 수에 맞게 한 라인의 포인트 생성")
    @Test
    void 플레이어수_라인생성() {
        Line line = TestLadderFactory.createRandomLine(4);
        assertThat(line.numberOfPoints()).isEqualTo(4);
    }

    @Test
    void 라인_이동() {
        List<Point> points = TestLadderFactory.createPoints(true, false, true, false);
        Line line = Line.of(() -> points);

        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(2)).isEqualTo(3);
        assertThat(line.move(3)).isEqualTo(2);
    }

    @Test
    void 오른쪽라인여부() {
        List<Point> points = TestLadderFactory.createPoints(true, false, false);
        Line line = Line.of(() -> points);

        assertThat(line.hasRightLine(1)).isFalse();
    }

}
