package ladder.model;

import org.junit.Test;

import static ladder.model.ArrowTest.BOTTOM_ARROW;
import static ladder.model.ArrowTest.LEFT_ARROW;
import static ladder.model.ArrowTest.RIGHT_ARROW;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    private static final Point DEFAULT_POINT = Point.from(0, RIGHT_ARROW);

    @Test
    public void 생성() {
        assertThat(DEFAULT_POINT).isNotNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void 생성_위치값_0미만() {
        Point.from(-1, RIGHT_ARROW);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 생성_위치값_0이면서_왼쪽이동() {
        Point.from(-1, LEFT_ARROW);
    }

    @Test
    public void 충돌_여부() {
        assertThat(DEFAULT_POINT.isCollapse(Point.from(1, RIGHT_ARROW)));
    }

    @Test
    public void 다음_위치() {
        assertThat(DEFAULT_POINT.nextPosition()).isEqualTo(1);
        assertThat(Point.from(1, BOTTOM_ARROW).nextPosition()).isEqualTo(1);
    }

    @Test
    public void 오른쪽으로_이동가능_여부() {
        assertThat(DEFAULT_POINT.isRight()).isTrue();
        assertThat(Point.from(1, LEFT_ARROW).isRight()).isFalse();
    }
}