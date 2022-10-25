package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Names;

public class LadderController {

    private final Names names;
    private final Ladder ladder;


    public LadderController(Names names, int height) {
        this.names = names;
        this.ladder = createLadder(this.names.getCountOfNames(), height);
    }

    public Ladder createLadder(int countOfNames, int height) {
        return new Ladder(countOfNames, height);
    }

    public Names getNames() {
        return names;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
