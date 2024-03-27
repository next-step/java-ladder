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

    @DisplayName("왼쪽으로 이동할 경우 -1 감소시킨다")
    @Test
    void moveLeft() {
        Position position = new Position(1);
        position.moveTo(Direction.LEFT);

        assertThat(position).isEqualTo(new Position(0));
    }

    @DisplayName("오른쪽으로 이동할 경우 +1 증가시킨다")
    @Test
    void moveRight() {
        Position position = new Position(0);
        position.moveTo(Direction.RIGHT);

        assertThat(position).isEqualTo(new Position(1));
    }

    @DisplayName("아래로 이동할 경우 현재 상태를 유지한다")
    @Test
    void moveDown() {
        Position position = new Position(1);
        position.moveTo(Direction.DOWN);

        assertThat(position).isEqualTo(new Position(1));
    }
}
