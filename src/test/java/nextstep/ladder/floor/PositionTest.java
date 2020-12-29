package nextstep.ladder.floor;

import nextstep.ladder.domain.floor.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositionTest {

    @Test
    public void moveLeft() {
        Position position = new Position(1, 3);
        position.moveLeft();

        assertThat(position.getCurrentPosition()).isEqualTo(0);
    }

    @Test
    public void isMostLeft_moveLeft_Exception() {
        Position position = new Position(0, 3);
        assertThat(position.isMostLeft()).isTrue();
        assertThatIllegalArgumentException().isThrownBy(position::moveLeft);
    }

    @Test
    public void moveRight() {
        Position position = new Position(1, 3);
        position.moveRight();

        assertThat(position.getCurrentPosition()).isEqualTo(2);
    }

    @Test
    public void isMostRight_moveRight_Exception() {
        Position position = new Position(2, 3);
        assertThat(position.isMostRight()).isTrue();
        assertThatIllegalArgumentException().isThrownBy(position::moveRight);
    }
}
