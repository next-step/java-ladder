package nextstep.ladder.domain.ladder;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import static nextstep.ladder.domain.ladder.LadderGenerator.createLadders;

public class Ladders {

    private TreeMap<Ladder, Boolean> laddersMap;
    private final Height height;

    public Ladders(int height, int row) {
        this(createLadders(row, height), height);
    }

    public Ladders(TreeMap<Ladder, Boolean> laddersMap, int height) {
        this(laddersMap, new Height(height));
    }

    public Ladders(TreeMap<Ladder, Boolean> laddersMap, Height height) {
        this.laddersMap = laddersMap;
        this.height = height;
    }

    public Map<Ladder, Boolean> getLadders() {
        return laddersMap;
    }

    public Height getHeight() {
        return height;
    }

    public int getHeightValue() {
        return height.getHeight();
    }

    @Override
    public String toString() {
        return "Ladders{" +
                "ladderMap=" + laddersMap +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ladders ladders = (Ladders) o;
        return Objects.equals(laddersMap, ladders.laddersMap) && Objects.equals(getHeight(), ladders.getHeight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(laddersMap, getHeight());
    }
}
