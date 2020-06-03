package ladder.domain.ladder;

import ladder.domain.ladder.strategy.RandomStairGenerationStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class StairStateTest {

    @DisplayName("첫 번째 기둥의 StairState 생성")
    @Test
    void createOfFirstPillar() {
        assertThatCode(() -> StairState.ofFirstPillar(new RandomStairGenerationStrategy()))
                .doesNotThrowAnyException();
    }

    @DisplayName("중간 기둥의 StairState 생성")
    @Test
    void createOfMiddlePillar() {
        assertThatCode(() -> StairState.ofFirstPillar(new RandomStairGenerationStrategy())
                .ofMiddlePillar(new RandomStairGenerationStrategy()))
                .doesNotThrowAnyException();
    }

    @DisplayName("마지막 기둥의 계단 또는 앞에 이미 계단이 있는 중간 기둥의 위치에는 계단이 없음")
    @Test
    void ofMiddlePillarWithNoLine() {
        assertThat(StairState.ofFirstPillar(new RandomStairGenerationStrategy())
                .ofMiddlePillarWithNoLine()
                .isExistLine())
                .isEqualTo(false);
    }
}
