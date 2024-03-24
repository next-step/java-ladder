package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {

    @Test
    void create() {
        Position position = new Position(1);
        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    void 움수값은_예외를_던진다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Position(-1))
                .withMessage("음수 값은 허용하지 않습니다");
    }

    @DisplayName("왼쪽으로 이동할 경우 -1 감소시킨 Position 객체 반환")
    @Test
    void moveLeft() {
        Position position = new Position(1);
        Position nextPosition = position.moveLeft();

        assertThat(nextPosition).isEqualTo(new Position(0));
    }

    @Test
    void 왼쪽으로_이동할수없는경우_예외를던진다() {
        Position position = new Position(0);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> position.moveLeft())
                .withMessage("왼쪽으로 이동할 수 없습니다");
    }

    @DisplayName("오른쪽으로 이동할 경우 +1 증가시킨 Position 객체 반환")
    @Test
    void moveRight() {
        Position position = new Position(0);
        Position nextPosition = position.moveRight();

        assertThat(nextPosition).isEqualTo(new Position(1));
    }
}
