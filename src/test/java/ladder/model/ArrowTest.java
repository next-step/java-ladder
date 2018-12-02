package ladder.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrowTest {
    public static final Arrow LEFT_ARROW = Arrow.LEFT;
    public static final Arrow RIGHT_ARROW = Arrow.RIGHT;
    public static final Arrow BOTTOM_ARROW = Arrow.BOTTOM;

    @Test
    public void 왼쪽으로_이동_가능한_상태() {
        assertThat(Arrow.valueOf(true, false)).isEqualTo(LEFT_ARROW);
    }

    @Test
    public void 오른쪽으로_이동_가능한_상태() {
        assertThat(Arrow.valueOf(false, true)).isEqualTo(RIGHT_ARROW);
    }

    @Test
    public void 아래쪽으로_이동_가능한_상태() {
        assertThat(Arrow.valueOf(false, false)).isEqualTo(BOTTOM_ARROW);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 이동이_불가능한_상태() {
        Arrow.valueOf(true, true);
    }

    @Test
    public void 방향에_따른_위치값() {
        assertThat(LEFT_ARROW.getIndex()).isEqualTo(-1);
        assertThat(BOTTOM_ARROW.getIndex()).isEqualTo(0);
        assertThat(RIGHT_ARROW.getIndex()).isEqualTo(1);
    }
}