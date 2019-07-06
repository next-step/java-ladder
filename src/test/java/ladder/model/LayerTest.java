package ladder.model;

import ladder.util.RandomRungGenerator;
import ladder.util.RungGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LayerTest {

    @Test
    @DisplayName("Layer.of")
    void layerTest() {
        RungGenerator rungGenerator = new RandomRungGenerator();
        int players = 4;
        Layer layer = Layer.of(rungGenerator, players);

        assertThat(layer.getDirections().size()).isEqualTo(3);

        layer.getDirections().forEach(System.out::println);
    }

    @Test
    @DisplayName("Constructor")
    void constructor() {
        List<Boolean> rungs = Arrays.asList(true, false, true);
        Layer layer = new Layer(rungs);

        assertThat(layer.getDirections()).containsExactly(
                Direction.RIGHT,
                Direction.LEFT,
                Direction.RIGHT,
                Direction.LEFT
        );
    }

    @Test
    @DisplayName("lastDirection")
    void lastDirection() {
        assertThat(Layer.lastDirection(Arrays.asList(true))).isEqualTo(Direction.LEFT);
        assertThat(Layer.lastDirection(Arrays.asList(false))).isEqualTo(Direction.PASS);
    }
}
