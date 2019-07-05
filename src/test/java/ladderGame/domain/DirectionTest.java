package ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DirectionTest {

    @Test
    @DisplayName("생성 테스트")
    public void createTest() {
        assertThat(Direction.of(0)).isEqualTo(Direction.RIGHT);
        assertThat(Direction.of(1)).isEqualTo(Direction.STRAIGHT);
        assertThat(Direction.of(2)).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("생성 범위 초과")
    public void matchException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Direction.of(4);
        });
    }
}