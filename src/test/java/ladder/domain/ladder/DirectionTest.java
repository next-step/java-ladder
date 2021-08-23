package ladder.domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Direction TEST")
class DirectionTest {

    @Test
    @DisplayName("첫번째 방향 RIGHT 생성")
    void firstDirection_generate() {
        // given
        // when
        Direction direction = Direction.ofFirst(() -> true);

        // then
        assertThat(direction).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("이전 방향이 RIGHT 일 경우 LEFT 여야 한다.")
    void beforeRight_nextLeft() {
        // given
        Direction beforeDirection = Direction.ofFirst(() -> true);

        // when
        Direction nextDirection = beforeDirection.ofNext(() -> true);

        // then
        assertThat(nextDirection).isEqualTo(Direction.LEFT);
    }

    @DisplayName("마지막 방향은 RIGHT 면 안된다")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void lastDirection_Straight(boolean isMove) {
        // given
        Direction direction = Direction.ofFirst(() -> isMove);

        // when
        Direction lastDirection = direction.ofLast();

        // then
        assertThat(lastDirection).isNotEqualTo(Direction.RIGHT);
    }
}