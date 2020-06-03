package ladder.domain.ladder;

import ladder.domain.ladder.strategy.RandomStairGenerationStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StairTest {

    @DisplayName("계단의 위치가 0보다 작으면 예외 반환")
    @Test
    void createFailure() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Stair.of(
                        Stair.FIRST_PILLAR_POSITION - 1,
                        StairState.ofFirstPillar(new RandomStairGenerationStrategy())));
    }

    @DisplayName("계단의 상태값이 null 이면 예외 반환")
    @Test
    void createFailureByStairStateIsNull() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Stair.of(Stair.FIRST_PILLAR_POSITION, null));
    }

    @DisplayName("첫 번째 기둥의 계단은 랜던 전략으로 생성")
    @Test
    void createOfFirstPillar() {
        assertThatCode(Stair::createOfFirstPillar)
                .doesNotThrowAnyException();
    }
}
