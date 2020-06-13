package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositionTest {

    @DisplayName("Position 생성 실패: 0보다 작은 위치값")
    @Test
    void createFailure() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Position.of(Position.MIN_POSITION - Position.ONE_STEP_POSITION));
    }

    @DisplayName("왼쪽으로 이동한 위치값 반환")
    @ParameterizedTest
    @ValueSource(ints = { Position.MIN_POSITION + 1, 10, 100 })
    void moveLeft(final int position) {
        assertThat(Position.of(position).moveLeft())
                .isEqualTo(Position.of(position - Position.ONE_STEP_POSITION));
    }

    @DisplayName("오른쪽으로 이동한 위치값 반환")
    @ParameterizedTest
    @ValueSource(ints = { Position.MIN_POSITION, 10, 100 })
    void moveRight(final int position) {
        assertThat(Position.of(position).moveRight())
                .isEqualTo(Position.of(position + Position.ONE_STEP_POSITION));
    }

    @DisplayName("위치값을 반환")
    @ParameterizedTest
    @ValueSource(ints = { Position.MIN_POSITION, 10, 100 })
    void getPosition(final int position) {
        assertThat(Position.of(position).getPosition())
                .isEqualTo(position);
    }

    @DisplayName("논리적 동치성 비교")
    @ParameterizedTest
    @ValueSource(ints = { Position.MIN_POSITION, 10, 100 })
    void equals(final int position) {
        assertThat(Position.of(position))
                .isEqualTo(Position.of(position));
    }
}
