package ladder.domain;

import ladder.service.RandomBoolean;
import ladder.service.RandomBooleanGenerator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Layer> layers;

    public Ladder(List<Layer> layers) {
        this.layers = layers;
    }

    public static Ladder valueOf(int line, int height) {
        return Ladder.valueOf(line, height, new RandomBooleanGenerator());
    }

    public static Ladder valueOf(int line, int height, RandomBoolean randomBoolean) {
        List<Layer> layers = IntStream.range(0, height)
                .mapToObj(i -> Layer.valueOf(line, randomBoolean))
                .collect(Collectors.toList());
        return new Ladder(layers);
    }

    public List<Layer> getLayers() {
        return this.layers;
    }

    private static List<Layer> generateLayers(int line, int height, RandomBoolean randomBoolean) {
        return IntStream.range(0, height)
                .mapToObj(i -> Layer.valueOf(line, randomBoolean))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladder ladder1 = (Ladder) o;
        return Objects.equals(layers, ladder1.layers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(layers);
    }
}
