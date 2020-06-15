package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class PositionTest {

    @Test
    void positionCreateTest() {
        assertThat(new Position(5)).isEqualTo(new Position(5));
        assertThat(new Position(5).getValue()).isEqualTo(5);
    }

    @Test
    void positionMoveTest() {
        Position position = new Position(5);
        assertThat(position.left()).isEqualTo(new Position(4));
        assertThat(position.right()).isEqualTo(new Position(6));
    }

    @Test
    void positionCreate_Fail_Test() {
        assertThatIllegalStateException().isThrownBy(() -> {
            new Position(-1);
        });

        Position position = new Position(0);
        assertThatIllegalStateException().isThrownBy(() -> {
            position.left();
        });
    }
}