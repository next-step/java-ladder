package ladder.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomCoordinateGeneratorTest {

    @Test
    @DisplayName("사다리 좌표를 생성했는지 확인")
    void 사다리_좌표생성() {
        CoordinateGenerator coordinateGeneration = new RandomCoordinateGenerator();
        assertThat(coordinateGeneration.generate()).isNotNull();
    }
}
