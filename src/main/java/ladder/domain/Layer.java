package ladder.domain;

import ladder.service.RandomBoolean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Layer {
    private final List<Boolean> aisles;

    public Layer(List<Boolean> aisles) {
        this.aisles = aisles;
    }

    public boolean hasAisle(int index) {
        return aisles.get(index);
    }

    public List<Boolean> getAisles() {
        return this.aisles;
    }

    public static Layer valueOf(int line, RandomBoolean randomBoolean) {
        List<Boolean> result = new ArrayList<>();
        result.add(randomBoolean.randomBoolean());
        for (int i = 1; i < line - 1; i++) {
            result.add(generateAisle(result.get(i - 1), randomBoolean));
        }
        return new Layer(result);
    }

    public int nextLine(int nowLine) {
        if (hasLeftAisle(nowLine)) {
            return nowLine - 1;
        }
        if (hasRightAisle(nowLine)) {
            return nowLine + 1;
        }
        return nowLine;
    }

    private boolean hasLeftAisle(int line) {
        if (line <= 0) {
            return false;
        }
        if (aisles.get(line - 1)) {
            return true;
        }
        return false;
    }

    private boolean hasRightAisle(int line) {
        if (line >= aisles.size()) {
            return false;
        }
        if (aisles.get(line)) {
            return true;
        }
        return false;
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

    public String printLayer() {
        return "";
    }
}
