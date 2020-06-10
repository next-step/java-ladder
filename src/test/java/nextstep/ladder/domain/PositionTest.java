package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    private Position position = Position.newInstance(3);

    @DisplayName("0보다 작으면 생성할 수 없다.")
    @Test
    void canNotCreatePositionIfLessThan0() {
        assertThatThrownBy(() -> Position.newInstance(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("객체를 생성할 수 있다.")
    @Test
    void canCreatePosition() {
        assertThat(this.position).isInstanceOf(Position.class);
    }

    @DisplayName("위치 값을 얻을 수 있다.")
    @Test
    void canGetValue() {
        assertThat(this.position.value()).isEqualTo(3);
    }

    @DisplayName("왼쪽으로 이동할 수 있다.")
    @Test
    void canMoveLeft() {
        Position left = this.position.left();
        assertThat(left).isInstanceOf(Position.class);
        assertThat(left.value()).isEqualTo(2);
    }

    @DisplayName("오른쪽으로 이동할 수 있다.")
    @Test
    void canMoveRight() {
        Position right = this.position.right();
        assertThat(right).isInstanceOf(Position.class);
        assertThat(right.value()).isEqualTo(4);
    }
}
