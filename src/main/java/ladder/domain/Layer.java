package ladder.domain;

import ladder.service.RandomBoolean;
import ladder.service.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Layer {
    private final List<Boolean> aisles;

    public Layer(int line) {
        this(generateAisles(line, new RandomBooleanGenerator()));
    }

    public Layer(int line, RandomBoolean randomBoolean) {
        this(generateAisles(line, randomBoolean));
    }

    public Layer(List<Boolean> aisles) {
        this.aisles = aisles;
    }

    public boolean hasAisle(int index) {
        return aisles.get(index);
    }

    private static List<Boolean> generateAisles(int line, RandomBoolean randomBoolean) {
        List<Boolean> result = new ArrayList<>();
        result.add(randomBoolean.randomBoolean());
        for (int i = 1; i < line - 1; i++) {
            result.add(generateAisle(result.get(i - 1), randomBoolean));
        }
        return result;
    }

    private static boolean generateAisle(boolean previousAisle, RandomBoolean randomBoolean) {
        if (randomBoolean.randomBoolean() && !previousAisle) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Layer layer = (Layer) o;
        return Objects.equals(aisles, layer.aisles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aisles);
    }
}
