package ladder.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    private static final int MOVE_SIZE = 1;

    @DisplayName("시작 지점 테스트")
    @Test
    void initTest() {
        assertThat(Position.init().location()).isZero();
    }

    @DisplayName("left 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void leftTest(int position) {
        assertThat(Position.of(position).left()).isEqualTo(Position.of(position - MOVE_SIZE));
    }

    @DisplayName("right 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void rightTest(int position) {
        assertThat(Position.of(position).right()).isEqualTo(Position.of(position + MOVE_SIZE));
    }
}