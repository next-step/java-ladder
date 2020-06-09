package ladder.domain.ladder.strategy;

import ladder.domain.ladder.StairState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomStairGenerationStrategyTest {

    @DisplayName("true 또는 false 를 반환")
    @Test
    void generate() {
        assertThat(RandomStairGenerationStrategy.getInstance().generate())
                .isIn(true, false);
    }

    @DisplayName("StairState 객체를 이용한 랜덤 전략 테스트")
    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    void trueOrFalse(final boolean randomResult) {
        assertThat(StairState.ofFirstPillar(() -> randomResult).isRightLineExist())
                .isEqualTo(randomResult);
    }
}
