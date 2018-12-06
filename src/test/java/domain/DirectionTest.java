package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class DirectionTest {

    @Test(expected = IllegalStateException.class)
    public void 연결선이_양쪽으로_이어지면_예외를_던진다() {
        Direction.of(true, true);
    }

    @Test
    public void 첫번째_사다리에서는_왼쪽으로_이동할_수_없다() {
        final Direction direction = Direction.first(true);
        assertThat(direction.isLeft()).isFalse();
    }

    @Test
    public void 마지막_사다리에서는_오른쪽으로_이동할_수_없다() {
        final Direction direction = Direction.of(false, false).last();
        assertThat(direction.isRight()).isFalse();
    }

}
