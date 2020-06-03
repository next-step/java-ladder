package ladder.domain.ladder.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomStairGenerationStrategyTest {

    @DisplayName("true 또는 false 를 반환")
    @Test
    void isGeneratable() {
        assertThat(new RandomStairGenerationStrategy().isGeneratable())
                .isIn(true, false);
    }
}
