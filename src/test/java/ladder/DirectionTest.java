package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class DirectionTest {
    @Test
    void createLeft() {
        Direction direction = Direction.of(true, false);
        assertThat(direction.isLeft()).isTrue();
    }

    @Test
    void createRight() {
        Direction direction = Direction.of(false, true);
        assertThat(direction.isRight()).isTrue();
    }
    @Test
    void createMiss() {
        Direction direction = Direction.of(false, false);
        assertThat(direction.isLeft()).isFalse();
        assertThat(direction.isRight()).isFalse();
    }

    @Test
    void createException() {
        assertThatIllegalArgumentException().isThrownBy(()->Direction.of(true, true));
    }
}