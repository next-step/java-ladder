package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private static final int START_INDEX = 0;

    public Ladder createLadder(List<String> users, int height) {
        Ladder ladder = new Ladder(users, height);

        List<Line> lines = ladder.createAllLines(new ArrayList<>(), START_INDEX);
        ladder.createLines(RandomGenerator.createRandomLine(lines, height));

        return ladder;
    }
}
