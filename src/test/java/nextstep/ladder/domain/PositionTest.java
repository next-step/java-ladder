package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    @DisplayName("오른쪽으로 이동하여 위치를 수정")
    void move_right_getPosition() {
        Position position = new Position();
        position.move(Direction.RIGHT);

        assertThat(position.getX()).isEqualTo(1);
        assertThat(position.getY()).isEqualTo(1);

        position.move(Direction.RIGHT);

        assertThat(position.getX()).isEqualTo(2);
        assertThat(position.getY()).isEqualTo(2);

    }

    @Test
    @DisplayName("왼쪽으로 이동하여 위치를 수정")
    void move_left_getPosition() {
        Position position = new Position(2, 3);
        position.move(Direction.LEFT);

        assertThat(position.getX()).isEqualTo(1);
        assertThat(position.getY()).isEqualTo(4);

        position.move(Direction.LEFT);

        assertThat(position.getX()).isEqualTo(0);
        assertThat(position.getY()).isEqualTo(5);
    }

    @Test
    @DisplayName("패스하여 y축의 위치를 수정")
    void getMovePass() {
        Position position = new Position(0, 0);

        position.move(Direction.PASS);

        assertThat(position.getX()).isEqualTo(0);
        assertThat(position.getY()).isEqualTo(1);

        position.move(Direction.PASS);

        assertThat(position.getX()).isEqualTo(0);
        assertThat(position.getY()).isEqualTo(2);
    }

    @Test
    void getPosition_IllegalArgumentException() {
        Position position = new Position(0, 1);

        assertThatThrownBy(() -> position.move(Direction.LEFT)).isInstanceOf(IllegalArgumentException.class);
    }

}
