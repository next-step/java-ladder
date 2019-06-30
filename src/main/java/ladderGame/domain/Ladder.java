package ladderGame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Layer> layers;

    private Ladder(List<Layer> layers) {
        this.layers = layers;
    }

    public static Ladder of(int numberOfPlayer, int height) {
        List<Layer> layers = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            layers.add(Layer.fromNumberOfPlayer(numberOfPlayer));
        }
        return new Ladder(layers);
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public int size() {
        return layers.size();
    }
}
