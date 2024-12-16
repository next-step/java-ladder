package nextstep.ladder.domain.laddergame.position;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveDirectionTest {

    @Test
    @DisplayName("왼쪽으로 이동이 가능할 경우 -1을 반환한다")
    void left() {
        Assertions.assertThat(MoveDirection.LEFT.getDirection()).isEqualTo(-1);
    }

    @Test
    @DisplayName("현재 위치가 1이고, 왼쪽으로 이동이 가능할 경우 최종 위치는 0이 된다")
    void move_left_position() {
        Position position = new Position(1 + MoveDirection.LEFT.getDirection());

        Assertions.assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("오른쪽으로 이동이 가능할 경우 +1을 반환한다")
    void right() {
        Assertions.assertThat(MoveDirection.RIGHT.getDirection()).isEqualTo(1);
    }

    @Test
    @DisplayName("현재 위치가 1이고, 오른쪽으로 이동이 가능할 경우 최종 위치는 2가 된다")
    void move_right_position() {
        Position position = new Position(1 + MoveDirection.RIGHT.getDirection());

        Assertions.assertThat(position.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("왼쪽, 오른쪽 모두 이동이 불가능한 경우 0을 반환한다")
    void pass() {
        Assertions.assertThat(MoveDirection.PASS.getDirection()).isEqualTo(0);
    }

    @Test
    @DisplayName("현재 위치가 1이고, 왼쪽과 오른쪽 모두 이동이 불가능한 경우 최종 위치는 그대로 1이 된다")
    void move_pass_position() {
        Position position = new Position(1 + MoveDirection.PASS.getDirection());

        Assertions.assertThat(position.getPosition()).isEqualTo(1);
    }
}