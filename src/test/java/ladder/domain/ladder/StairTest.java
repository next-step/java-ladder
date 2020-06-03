package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class StairTest {

    @DisplayName("첫 번째 기둥의 계단은 랜던 전략으로 생성")
    @Test
    void createOfFirstPillar() {
        assertThatCode(Stair::createOfFirstPillar)
                .doesNotThrowAnyException();
    }
}
