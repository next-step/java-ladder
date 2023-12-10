package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BridgesGeneratorBySequentialRandomTest {

    private final BridgesGenerator bridgesGenerator = new BridgesGeneratorBySequentialRandom();

    @Test
    public void generateBridges_다리_개수_확인() {
        assertThat(bridgesGenerator.generateBridges(5)).hasSize(4);
    }
}
