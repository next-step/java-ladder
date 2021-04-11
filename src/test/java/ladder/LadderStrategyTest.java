package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderStrategyTest {
    @DisplayName("사다리그리기전략의 방향결정 테스트")
    @Test
    void direction() {
        LadderStrategy strategy = () -> Direction.RIGHT;
        assertThat(strategy.direction()).isEqualTo(Direction.RIGHT);
    }
}
