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
    public void left_right_가_전부_true_일수는_없다() {
        Direction direction = Direction.first(true).next(true);
        assertThat(direction.rightMovable()).isFalse();
    }

    @Test
    public void 다음_방향을_반환한다() {
        Direction direction1 = Direction.first(true).next(false);
        assertThat(direction1.leftMovable()).isTrue();
        Direction direction2 = Direction.first(false).next(false);
        assertThat(direction2.leftMovable()).isFalse();
    }

    @Test
    public void 마지막_방향을_반환한다() {
        Direction direction = Direction.first(true).last();
        assertThat(direction.rightMovable()).isFalse();
    }
}
