package ladder.domain;

import ladder.service.RandomBoolean;
import ladder.service.RandomBooleanGenerator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private final List<Layer> ladder;

    public Ladder(int line, int height) {
        this(generateLayers(line, height, new RandomBooleanGenerator()));
    }

    public Ladder(int line, int height, RandomBoolean randomBoolean) {
        this(generateLayers(line, height, randomBoolean));
    }

    public Ladder(List<Layer> layers) {
        this.ladder = layers;
    }

    public Stream<Layer> stream() {
        return this.ladder.stream();
    }

    private static List<Layer> generateLayers(int line, int height, RandomBoolean randomBoolean) {
        return IntStream.range(0, height)
                .mapToObj(i -> new Layer(line, randomBoolean))
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
        return Objects.equals(ladder, ladder1.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder);
    }
}
