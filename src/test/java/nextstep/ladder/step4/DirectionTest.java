package nextstep.ladder.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    void randomNextTrueTest() {
        Direction direction = Direction.of(false, true);
        assertThat(direction.next()).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("Direction의 right가 false이면, 다음(오른쪽) Direction은 left가 false여야 한다.")
    void randomNextFalseTest() {
        Direction direction = Direction.of(false, false);
        assertThat(direction.next().isLeft()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("다음(오른쪽) Direction의 right의 값을 지정한 경우")
    void nextTrueTest(boolean nextRight) {
        Direction direction = Direction.of(false, false);
        Direction next = direction.next(nextRight);
        assertThat(next.isRight()).isEqualTo(nextRight);
    }

    @Test
    @DisplayName("first(첫번째) Direction의 left는 false여야 한다.")
    void firstDirectionTest() {
        Direction first = Direction.first(true);
        assertThat(first.isLeft()).isFalse();
    }

    @Test
    @DisplayName("last(마지막) Direction의 right는 false여야 한다.")
    void lastDirectionTest() {
        Direction last = Direction.last(true);
        assertThat(last.isRight()).isFalse();
    }
}
