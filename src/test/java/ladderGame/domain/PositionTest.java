package ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {

    @Test
    @DisplayName("왼쪽으로 움직이기")
    public void moveLeft() {
        Position position = new Position(1);
        assertThat(position.moveBy(Direction.LEFT)).isEqualTo(new Position(0));
    }

    @Test
    @DisplayName("오른쪽으로 움직이기")
    public void moveRight() {
        Position position = new Position(1);
        assertThat(position.moveBy(Direction.RIGHT)).isEqualTo(new Position(2));
    }

    @Test
    @DisplayName("아래로 움직이기")
    public void moveStraight() {
        Position position = new Position(1);
        assertThat(position.moveBy(Direction.STRAIGHT)).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("왼쪽으로 더이상 갈수 없음 예외처리")
    public void moveLeftException() {
        Position position = new Position(0);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            position.moveBy(Direction.LEFT);
        });
    }
}