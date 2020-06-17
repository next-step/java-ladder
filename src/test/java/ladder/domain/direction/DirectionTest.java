package ladder.domain.direction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DirectionTest {

    @DisplayName("객체 생성 테스트")
    @Test
    void init() {
        Direction direction = Direction.of(true, false);

        assertThat(direction).isEqualTo(Direction.of(true, false));
        assertThat(direction).isNotEqualTo(Direction.of(false, true));
    }

    @DisplayName("양 방향으로 향하고자 하면 IllegalArgumentException")
    @Test
    void init_invalid() {
        assertThatThrownBy(() -> Direction.of(true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("오른쪽의 다음 방향은 왼쪽이다")
    @Test
    void right_next_left() {
        Direction direction = Direction.of(false, true);

        Direction nextDirection = direction.next(true);

        assertThat(nextDirection).isEqualTo(Direction.of(true, false));
    }

    @DisplayName("왼쪽의 다음 방향은 제자리이거나 오른쪽이다")
    @Test
    void notRight_nextIsGivenValue() {
        Direction direction = Direction.of(false, false);

        Direction rightDirection = direction.next(true);
        Direction stayDirection = direction.next(false);

        assertAll(
                () -> assertThat(rightDirection).isEqualTo(Direction.of(false, true)),
                () -> assertThat(stayDirection).isEqualTo(Direction.of(false, false)));
    }

    @DisplayName("첫 번째 방향은 왼쪽일 수 없다")
    @Test
    void fist_not_left() {
        Direction direction = Direction.first(false);

        assertThat(direction).isNotEqualTo(Direction.of(true, false));
    }

    @DisplayName("마지막 방향은 오른쪽일 수 없다")
    @Test
    void last_not_right() {
        Direction direction = Direction.last(false);

        assertThat(direction).isNotEqualTo(Direction.of(false, true));
    }
}
