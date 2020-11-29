package nextstep.ladder.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class DirectionTest {
    @Test
    void init() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("Direction의 left와 right가 모두 true인 경우 throw Exception")
    void invalidStateTest() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> Direction.of(true, true))
                .withMessage(Direction.INVALID_STATE_ERR_MSG);
    }

    @Test
    @DisplayName("Direction의 right가 true이면, 다음(오른쪽) Direction은 of(true, false)여야 한다.")
    void nextRightDirectionTest() {
        Direction direction = Direction.of(false, true);
        assertThat(direction.next()).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("first(첫번째) Direction의 left는 false여야 한다.")
    void firstDirectionTest() {
        Direction first = Direction.first(true);
        assertThat(first.isLeft()).isFalse();
    }
}
