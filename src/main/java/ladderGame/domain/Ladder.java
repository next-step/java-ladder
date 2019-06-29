package ladderGame.domain;

import java.util.List;

public class Ladder {

    private List<Layer> layers;

    public Ladder(List<Layer> layers) {
        this.layers = layers;
    }

    public static Ladder of(List<Layer> layers) {
        return new Ladder(layers);
    }

    public int size() {
        return layers.size();
    }
}
