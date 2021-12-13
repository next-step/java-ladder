package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class DirectionTest {
    public static final Direction LEFT_DIRECTION = Direction.of(TRUE, FALSE);
    public static final Direction RIGHT_DIRECTION = Direction.of(FALSE, TRUE);
    public static final Direction NO_DIRECTION = Direction.of(FALSE, FALSE);

    @DisplayName("Compare with the instance with same data")
    @Test
    public void init() {
        assertThat(Direction.of(TRUE, FALSE)).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @DisplayName("If direction instance indicates both left and right, it throws exception.")
    @Test
    public void init_invalid() {
        assertThatThrownBy(() ->
                Direction.of(TRUE, TRUE)).isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("If direction is right, next direction must be left.")
    @Test
    public void next_random_true() {
        Direction next = Direction.first(TRUE).next();
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    public void next_random_false() {
        Direction next = Direction.first(FALSE).next();
        assertThat(next).isIn(Direction.of(FALSE, TRUE), Direction.of(FALSE, FALSE));
    }

    @DisplayName("If direction is left and right flag is on, next direction must be right.")
    @Test
    public void next_true() {
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        assertThat(next).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @DisplayName("If direction is right and right flag is off, next direction must be left.")
    @Test
    public void next_false() {
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @DisplayName("If direction is first, left is impossible.")
    @Test
    public void first() {
        Direction first = Direction.first(TRUE);
        assertThat(first.isLeft()).isFalse();
    }

    @DisplayName("If direction is last, right is impossible.")
    @Test
    public void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last).isEqualTo(Direction.of(TRUE, FALSE));
    }
}
