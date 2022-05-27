package ladder.domain;

import ladder.constant.Direction;
import ladder.exception.InvalidBoundPositionException;
import ladder.exception.NotMoveException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    @DisplayName("0 보다 작은 Position 으로 생성할 경우 InvalidBoundPositionException 를 반환한다.")
    void invalidPosition_Min() {
        assertThatThrownBy(() -> new Position(1, -1))
                .isInstanceOf(InvalidBoundPositionException.class)
                .hasMessage("0 ~ 1 사이의 값만 가능합니다.");
    }

    @Test
    @DisplayName("최댓값 보다 큰 Position 으로 생성할 경우 InvalidBoundPositionException 를 반환한다.")
    void invalidPosition_Max() {
        assertThatThrownBy(() -> new Position(1, 2))
                .isInstanceOf(InvalidBoundPositionException.class)
                .hasMessage("0 ~ 1 사이의 값만 가능합니다.");
    }

    @Test
    @DisplayName("포지션 값이 최솟값일때 왼쪽으로 이동하면 예외를 반환한다.")
    void invalidDown() {
        Position position = new Position(2, 0);

        assertThatThrownBy(() -> position.change(Direction.LEFT))
                .isInstanceOf(NotMoveException.class)
                .hasMessage("현재 위치가 최소 혹은 최대이라서 움직일 수 없습니다. 최솟값=0, 최댓값=2, 현재 위치=0");
    }

    @Test
    @DisplayName("왼쪽으로 이동하면 포지션 값이 1 감소한다.")
    void down() {
        Position position = new Position(2, 1);

        position.change(Direction.LEFT);

        assertThat(position).isEqualTo(new Position(2, 0));
    }

    @Test
    @DisplayName("포지션 값이 최댓값일때 오른쪽으로 이동하면 예외를 반환한다.")
    void invalidUp() {
        Position position = new Position(2, 2);

        assertThatThrownBy(() -> position.change(Direction.RIGHT))
                .isInstanceOf(NotMoveException.class)
                .hasMessage("현재 위치가 최소 혹은 최대이라서 움직일 수 없습니다. 최솟값=0, 최댓값=2, 현재 위치=2");
    }

    @Test
    @DisplayName("오른쪽으로 이동하면 포지션 값이 1 증가한다.")
    void up() {
        Position position = new Position(2, 1);

        position.change(Direction.RIGHT);

        assertThat(position).isEqualTo(new Position(2, 2));
    }
}