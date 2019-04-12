package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static ladder.domain.Fixture.*;

public class PointTest {

    @Test
    public void 앞다리_true면_뒷다리는_false테스트() {
        Point result = FIRST_POINT.next();
        Assertions.assertThat(result).isEqualTo(new Point(1,Direction.of(true, false)));
    }

    @Test
    public void 오른쪽_이동테스트_move() {
        int result = FIRST_POINT.move();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void 왼쪽_이동테스트_move() {
        int result = LAST_POINT.move();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void 이동안함_테스트_move() {
        int result = new Point(0, DOUBLE_FALSE).move();
        Assertions.assertThat(result).isEqualTo(0);
    }
}
