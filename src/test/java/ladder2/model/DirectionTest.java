package ladder2.model;

import org.junit.Test;

import static ladder2.util.DefaultLadderPointGeneratorTest.DEFAULT_LADDER_POINT_GENERATOR;
import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
    public static final Direction DEFAULT_DIRECTION = Direction.from(false, true);

    @Test
    public void 생성() {
        assertThat(Direction.from(true, false)).isEqualTo(Direction.from(true, false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 생성_실패() {
        Direction.from(true, true);
    }

    @Test
    public void 다음_방향_False() {
        Direction next = Direction.first(true).next(DEFAULT_LADDER_POINT_GENERATOR);
        assertThat(next).isEqualTo(Direction.from(true, false));
    }

    @Test
    public void 다음_방향_True() {
        Direction next = Direction.from(true, false).next(true);
        assertThat(next).isEqualTo(Direction.from(false, true));
    }

    @Test
    public void 다음_방향_비교() {
        Direction next = Direction.from(false, true).next(false);
        assertThat(next).isEqualTo(Direction.from(true, false));
    }

    @Test
    public void 시작_방향_True() {
        Direction first = Direction.first(true);
        assertThat(first.isLeft()).isFalse();
    }

    @Test
    public void 마지막_이후_방향_False() {
        Direction last = Direction.first(true).last();
        assertThat(last).isEqualTo(Direction.from(true, false));
    }

}