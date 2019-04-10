package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PointTest {

    @Test
    public void 첫다리_생성() {
        Point result = Point.first(false);
        Assertions.assertThat(result).isEqualTo(new Point(false, false));
    }

    @Test
    public void 막다리_생성() {
        Point result = Point.last(false);
        Assertions.assertThat(result).isEqualTo(new Point(false, false));
    }

    @Test
    public void 맨앞다리_생성_확인() {
        Point result = Point.first(false).next(true);
        Assertions.assertThat(result).isEqualTo(new Point(false, true));
    }

    @Test
    public void 앞다리_true면_뒷다리는_false테스트() {
        Point result = Point.first(true).next(true);
        Assertions.assertThat(result).isEqualTo(new Point(true, false));
    }

    @Test
    public void 오른쪽_이동테스트_move() {
        int result = Point.first(true).move(0);
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void 왼쪽_이동테스트_move() {
        int result = Point.last(true).move(1);
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void 이동안함_테스트_move() {
        int result = Point.first(false).move(0);
        Assertions.assertThat(result).isEqualTo(0);
    }
}
