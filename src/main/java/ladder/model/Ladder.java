package ladder.model;

import ladder.util.RandomRungGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Layer> layers;

    public Ladder(final List<Layer> layers) {
        this.layers = layers;
    }

    public static Ladder of(int countOfPlayers, int height) {
        List<Layer> layers = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            layers.add(Layer.of(new RandomRungGenerator(), countOfPlayers));
        }
        return new Ladder(layers);
    }

    public List<Layer> getLayers() {
        return Collections.unmodifiableList(layers);
    }
}
