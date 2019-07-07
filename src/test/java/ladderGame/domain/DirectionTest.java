package ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DirectionTest {

    @Test
    @DisplayName("생성 테스트")
    public void createTest() {
        assertThat(Direction.of(false, true)).isEqualTo(Direction.RIGHT);
        assertThat(Direction.of(false, false)).isEqualTo(Direction.STRAIGHT);
        assertThat(Direction.of(true, false)).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("방향 생성 예외처리")
    public void matchException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Direction.of(true, true);
        });
    }
}