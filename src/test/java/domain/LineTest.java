package domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void 이동가능한_포인트가_연속되지_않아야한다() {
        Line line = new Line(3, new MockLottery());
        List<Point> points = line.getPoints();
        assertThat(points.get(0).isMovable()).isTrue();
        assertThat(points.get(1).isMovable()).isFalse();
        assertThat(points.get(2).isMovable()).isFalse();
    }

    @Test
    public void 포인트가_라인에_있는지_체크한다() {
        Line line = new Line(1, new RandomNumberLottery());
        assertThat(line.contains(Point.valueOf(1, true))).isTrue();
    }

    class MockLottery implements Lottery {
        @Override
        public boolean test() {
            return true;
        }
    }
}
