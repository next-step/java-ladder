package ladder.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomCoordinateGenerationTest {

    @Test
    @DisplayName("사다리 좌표를 생성했는지 확인")
    void 사다리_좌표생성() {
        CoordinateGeneration coordinateGeneration = new RandomCoordinateGeneration();
        assertThat(coordinateGeneration.generate()).isNotNull();
    }
}
