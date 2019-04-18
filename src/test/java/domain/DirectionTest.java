package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
    @Test
    public void 첫번째_방향을_반환한다() {
        Direction direction = Direction.first(true);
        assertThat(direction.leftMovable()).isFalse();
    }

    @Test
    public void right_true의_다음은_left_true이다() {
        Direction direction = Direction.first(true).next(false);
        assertThat(direction.leftMovable()).isTrue();
    }

    @Test
    public void right_false의_다음은_left_false이다() {
        Direction direction = Direction.first(false).next(false);
        assertThat(direction.leftMovable()).isFalse();
    }

    @Test
    public void left_right_가_전부_true_일수는_없다() {
        Direction direction = Direction.first(true).next(true);
        assertThat(direction.rightMovable()).isFalse();
    }

    @Test
    public void 마지막_방향을_반환한다() {
        Direction direction = Direction.first(true).last();
        assertThat(direction.rightMovable()).isFalse();
    }
}
