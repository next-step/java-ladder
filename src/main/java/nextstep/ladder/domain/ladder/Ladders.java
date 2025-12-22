package nextstep.ladder.domain.ladder;

import java.util.Map;

import static nextstep.ladder.domain.ladder.LadderGenerator.createLadders;

public class Ladders {

    private Map<Ladder, Boolean> laddersMap;
    private final Integer height;

    public Ladders(int height, int row) {
        this.laddersMap = createLadders(row, height);
        this.height = height;
    }

    public Ladders(Map<Ladder,Boolean> laddersMap, Integer height) {
        this.laddersMap = laddersMap;
        this.height = height;
    }

    public Map<Ladder, Boolean> getLadders() {
        return laddersMap;
    }

    public Integer getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Ladders{" +
                "ladderMap=" + laddersMap +
                ", height=" + height +
                '}';
    }
}
