package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private static final int START_INDEX = 1;

    public Ladder createLadder(List<String> users, int height) {
        Ladder ladder = new Ladder(users, height);

        List<Line> lines = ladder.createAllLines(new ArrayList<>(), 1, users.size());
        ladder.createLines(RandomGenerator.createRandomLine(lines, height));

        return ladder;
    }
}
