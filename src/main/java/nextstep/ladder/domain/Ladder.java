package nextstep.ladder.domain;

import java.util.logging.Level;

public class Ladder {

    private LadderHeight ladderHeight;
    private int ladderWeight;

    private Ladder(LadderHeight ladderHeight, int countOfPerson) {
        this.ladderHeight = ladderHeight;
        this.ladderWeight = countOfPerson;
    }


}
