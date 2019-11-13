package ladder.domain;

import java.util.List;

public class LadderGame {

    public Ladder createLadder(List<String> users, List<String> outcomes, int height) {
        Ladder ladder = new Ladder(users, outcomes, height);
        ladder.createLines();

        return ladder;
    }

    public List<UserRecord> run(Ladder ladder) {
        return ladder.run();
    }

}
