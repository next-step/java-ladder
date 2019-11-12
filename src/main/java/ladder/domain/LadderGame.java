package ladder.domain;

import java.util.List;

public class LadderGame {

    public Ladder createLadder(List<String> users, int height) {
        Ladder ladder = new Ladder(users, height);
        ladder.createLines();

        return ladder;
    }
}
