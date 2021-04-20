package ladder.domain;

import ladder.service.RandomBoolean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Layer {
    private final List<Aisle> aisles;

    public Layer(List<Aisle> aisles) {
        this.aisles = aisles;
    }

    public boolean hasAisle(int index) {
        return aisles.get(index).isExistAisle();
    }

    public static Layer valueOf(List<Boolean> aisles) {
        return new Layer(aisles.stream()
                .map(aisle -> new Aisle(aisle))
                .collect(Collectors.toList()));
    }

    public static Layer valueOf(int line, RandomBoolean randomBoolean) {
        List<Aisle> result = new ArrayList<>();
        result.add(new Aisle(randomBoolean.randomBoolean()));
        for (int i = 1; i < line - 1; i++) {
            result.add(Aisle.generateAisle(result.get(i - 1), randomBoolean));
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

    public String printLayer() {
        StringBuilder sb = new StringBuilder();
        this.aisles.stream()
                .forEach(aisle -> sb.append("|").append(aisle.printAisle()));
        sb.append("|");
        return sb.toString();
    }

    private boolean hasLeftAisle(int line) {
        if (line <= 0) {
            return false;
        }
        if (aisles.get(line - 1).isExistAisle()) {
            return true;
        }
        return false;
    }

    private boolean hasRightAisle(int line) {
        if (line >= aisles.size()) {
            return false;
        }
        if (aisles.get(line).isExistAisle()) {
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
