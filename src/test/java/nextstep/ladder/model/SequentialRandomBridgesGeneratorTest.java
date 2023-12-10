package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class SequentialRandomBridgesGeneratorTest {

    private final BridgesGenerator bridgesGenerator = new SequentialRandomBridgesGenerator();

    @Test
    public void generateBridges_다리_개수_확인() {
        assertThat(bridgesGenerator.generateBridges(5)).hasSize(4);
    }


}
