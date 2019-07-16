package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DirectionTest {
    @Test
    @DisplayName("LEFT는 왼쪽으로 간다.")
    void move_Left() {
        final Direction direction = Direction.LEFT;
        assertThat(direction.move(1)).isEqualTo(0);
    }

    @Test
    @DisplayName("Right는 오른쪽으로 간다.")
    void move_Right() {
        final Direction direction = Direction.RIGHT;
        assertThat(direction.move(1)).isEqualTo(2);
    }

    @Test
    @DisplayName("DOWN는 제자리로 내려간다.")
    void move_Down() {
        final Direction direction = Direction.DOWN;
        assertThat(direction.move(1)).isEqualTo(1);
    }

    @Test
    @DisplayName("첫 방향을 생성할 수 있다.")
    void firstOf() {
        final Direction direction = Direction.firstOf(() -> true);
        assertThat(direction).isEqualByComparingTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("다음 방향을 생성할 수 있다.")
    void nextOf() {
        final Direction direction = Direction.firstOf(() -> true);
        assertThat(direction.nextOf(() -> true)).isEqualByComparingTo(Direction.LEFT);
    }

    @Test
    @DisplayName("마지막 방향을 생성할 수 있다.")
    void endOf() {
        final Direction direction = Direction.firstOf(() -> false);
        assertThat(direction.endOf()).isEqualByComparingTo(Direction.DOWN);
    }
}
