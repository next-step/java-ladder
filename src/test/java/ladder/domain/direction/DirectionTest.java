package ladder.domain.direction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DirectionTest {

    @DisplayName("오른쪽의 다음 방향은 isNextRight 인자와 상관없이 왼쪽이다")
    @Test
    void right_next_left() {
        Direction right = Direction.RIGHT;
        Direction nextDirection = right.next(true);

        assertThat(nextDirection).isEqualTo(Direction.LEFT);
    }

    @DisplayName("왼쪽의 다음 방향은 isNextRight 인자에 따라 제자리이거나 오른쪽이다")
    @Test
    void notRight_nextIsGivenValue() {
        Direction left = Direction.LEFT;

        Direction rightDirection = left.next(true);
        Direction stayDirection = left.next(false);

        assertAll(
                () -> assertThat(rightDirection).isEqualTo(Direction.RIGHT),
                () -> assertThat(stayDirection).isEqualTo(Direction.STAY));
    }

    @DisplayName("첫 번째 방향은 왼쪽일 수 없다")
    @Test
    void fist_not_left() {
        Direction direction = Direction.first(false);

        assertThat(direction).isNotEqualTo(Direction.LEFT);
    }

    @DisplayName("마지막 방향은 오른쪽일 수 없다")
    @Test
    void last_not_right() {
        Direction direction = Direction.last(false);

        assertThat(direction).isNotEqualTo(Direction.RIGHT);
    }
}
