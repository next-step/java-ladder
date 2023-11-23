package ladder.domain;

import ladder.domain.strategy.CoordinateGeneration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<LadderLine> ladder;

    public Ladder(People people, Height heightCount, CoordinateGeneration coordinateGeneration) {
        this.ladder = makeLadder(people, heightCount, coordinateGeneration);
    }

    private static List<LadderLine> makeLadder(People people, Height heightCount, CoordinateGeneration coordinateGeneration) {
        List<LadderLine> list = new ArrayList<>();
        for (int i = 0; i < heightCount.find(); i++) {
            list.add(new LadderLine(people, coordinateGeneration));
        }
        return list;
    }


    public List<LadderLine> draw() {
        return Collections.unmodifiableList(ladder);
    }
}
