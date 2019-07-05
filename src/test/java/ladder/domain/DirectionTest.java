package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class DirectionTest {

    @Test
    @DisplayName("최초 플레이어의 포지션이 생성되고 움직이지 않는다.")
    void generateFirstPositionToStay() {
        Boolean right = false;
        Direction direction = Direction.first(right);
        assertThat(direction.isRight()).isEqualTo(Direction.of(false, false).isRight());
    }

    @Test
    @DisplayName("최초 플레이어의 포지션이 생성되고 오른쪽으로 움직인다.")
    void generateFirstPositionToMove() {
        Boolean right = true;
        Direction direction = Direction.first(right);
        assertThat(direction.isRight()).isEqualTo(Direction.of(false, true).isRight());
    }

    @Test
    @DisplayName("중간 플레이어의 포지션이 처음 생성되고 움직이지 않는다.")
    void generateMiddlePositionToStay() {
        boolean left = false;
        boolean right = false;
        Direction direction = Direction.of(left, right);
        assertThat(direction.isRight()).isEqualTo(false);
        assertThat(direction.isLeft()).isEqualTo(false);
    }

    @Test
    @DisplayName("중간 플레이어의 포지션이 생성시 예외 상황")
    void generateMiddlePositionToException() {
        boolean left = true;
        boolean right = true;
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Direction.of(left, right);
        });
    }

    @Test
    @DisplayName("중간 플레이어의 포지션이 처음 생성되고 오른쪽으로 움직인다.")
    void generateMiddlePositionToRight() {
        boolean left = false;
        boolean right = true;
        Direction direction = Direction.of(left, right);
        assertThat(direction.isRight()).isEqualTo(true);
    }

    @Test
    @DisplayName("중간 플레이어의 포지션이 처음 생성되고 왼쪽으로 움직인다.")
    void generateMiddlePositionToLeft() {
        boolean left = true;
        boolean right = false;
        Direction direction = Direction.of(left, right);
        assertThat(direction.isLeft()).isEqualTo(true);
    }

    @Test
    @DisplayName("마지막 플레이어의 포지션이 생성되고 움직이지 않는다.")
    void generateLastPositionToStay() {
        Boolean left = false;
        Direction direction = Direction.last(left);
        assertThat(direction.isLeft()).isEqualTo(Direction.of(false, false).isLeft());
    }

    @Test
    @DisplayName("마지막 플레이어의 포지션이 생성되고 왼쪽으로 움직인다.")
    void generateListPositionToMove() {
        Boolean left = true;
        Direction direction = Direction.last(left);
        assertThat(direction.isLeft()).isEqualTo(Direction.of(false, true).isLeft());
    }
}
