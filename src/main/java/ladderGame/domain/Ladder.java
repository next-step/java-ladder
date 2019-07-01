package ladderGame.domain;

import ladderGame.util.RandomRungsGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private List<Layer> layers;

    private Ladder(List<Layer> layers) {
        this.layers = layers;
    }

    public static Ladder of(int numberOfPlayer, int height) {
        return new Ladder(IntStream.range(0, height)
                .mapToObj(i -> Layer.ofGenerator(numberOfPlayer, new RandomRungsGenerator()))
                .collect(Collectors.toList()));
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public int size() {
        return layers.size();
    }
}
