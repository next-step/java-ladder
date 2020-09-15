package cc.oakk.ladder.model.line;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class DirectionTest {
    @Test
    public void of() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
        assertThat(Direction.of(false, true)).isEqualTo(Direction.of(false, true));
        assertThat(Direction.of(false, false)).isEqualTo(Direction.of(false, false));
    }

    @Test
    public void basic() {
        assertThat(Direction.basic()).isEqualTo(Direction.of(false, false));
    }

    @Test
    public void next() {
        assertThat(Direction.of(false, true).next(false)).isEqualTo(Direction.of(true, false));
        assertThat(Direction.of(true, false).next(true)).isEqualTo(Direction.of(false, true));
    }

    @Test
    public void of_ShouldThrow() {
        assertThatIllegalArgumentException().isThrownBy(() -> Direction.of(true, true));
    }

    @Test
    public void isLeft() {
        assertThat(Direction.of(true, false).isLeft()).isTrue();
        assertThat(Direction.of(false, true).isLeft()).isFalse();
        assertThat(Direction.of(false, false).isLeft()).isFalse();
    }

    @Test
    public void isRight() {
        assertThat(Direction.of(true, false).isRight()).isFalse();
        assertThat(Direction.of(false, true).isRight()).isTrue();
        assertThat(Direction.of(false, false).isRight()).isFalse();
    }
}
