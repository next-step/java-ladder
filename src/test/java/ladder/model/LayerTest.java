package ladder.model;

import ladder.util.RandomRungGenerator;
import ladder.util.RungGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LayerTest {

    @Test
    @DisplayName("Layer.of")
    void layerTest() {
        RungGenerator rungGenerator = new RandomRungGenerator();
        int players = 4;
        Layer layer = Layer.of(rungGenerator, players);

        assertThat(layer.getRungs().size()).isEqualTo(3);
    }
}
