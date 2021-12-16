package ladder;

import ladder.domain.Point;
import ladder.domain.Way;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    void 방향_초기화시_왼쪽방향일수_없다() {
        Point point = new Point();
        Assertions.assertThat(point.getWay()).isNotEqualTo(Way.LEFT);
    }

    @Test
    void 왼쪽포인트가_오른쪽으로_향할시_왼쪽방향_길로_초기화된다() {
        Point leftPoint = new Point(Way.RIGHT);
        Point point = new Point(leftPoint, true);
        Assertions.assertThat(point.getWay()).isEqualTo(Way.LEFT);
    }

    @Test
    void 왼쪽포인트가_아래로_향할시_왼쪽방향으로_초기화되지_않는다() {
        Point leftPoint = new Point(Way.DOWN);
        Point point = new Point(leftPoint, true);
        Assertions.assertThat(point.getWay()).isNotEqualTo(Way.LEFT);
    }

    @Test
    void 오른쪽_포인트가_존재하지_않을_시_오른쪽방향으로_초기화되지_않는다() {
        Point leftPoint = new Point(Way.DOWN);
        Point point = new Point(leftPoint, false);
        Assertions.assertThat(point.getWay()).isNotEqualTo(Way.RIGHT);
    }
}
