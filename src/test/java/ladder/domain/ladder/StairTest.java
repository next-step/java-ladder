package ladder.domain.ladder;

import ladder.domain.ladder.strategy.RandomStairGenerationStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("중간 기둥의 계단은 앞에 계단이 있으면 계단을 생성 X, 없으면 랜덤 전략으로 계단 생성 : T -> F, F -> T/F")
    @Test
    void createOfMiddlePillar() {
        Stair previousStair = Stair.of(Stair.FIRST_PILLAR_POSITION,
                StairState.ofFirstPillar(new RandomStairGenerationStrategy()));

        boolean existLineOfPreviousStair = previousStair.isExistLine();
        boolean existLine = previousStair.createOfMiddlePillar().isExistLine();

        assertThat(existLineOfPreviousStair && existLine).isFalse();
    }

    @DisplayName("마지막 기둥에는 계단을 둘 수 없음")
    @Test
    void createOfLastPillar() {
        assertThat(Stair.createOfFirstPillar().createOfLastPillar()
                .isExistLine())
                .isEqualTo(false);
    }
}
