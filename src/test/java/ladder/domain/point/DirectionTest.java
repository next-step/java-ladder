package ladder.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DirectionTest {

    @DisplayName("first 테스트")
    @Test
    void firstTest() {
        assertThat(Direction.first(Boolean.TRUE).isLeft()).isFalse();
    }

    @DisplayName("last 테스트")
    @Test
    void lastTest() {
        assertThat(Direction.of(false, true).last().isRight()).isFalse();
    }

    @DisplayName("next 테스트")
    @Test
    void nextTest() {
        assertThat(Direction.of(false, true).next(() -> true).isLeft()).isTrue();
    }

    @DisplayName("예외처리 테스트")
    @Test
    void validateDirection() {
        assertThatIllegalStateException().isThrownBy(() -> Direction.of(true, true));
    }
}