package nextstep.ladder.model;

import java.util.List;
import java.util.Random;

public class LadderService {

    private final List<Name> names;
    private final Ladder ladder;

    public LadderService(LadderHeight heightOfLadder, PersonCount countOfPerson, List<Name> names, Random random) {
        ladder = new Ladder(heightOfLadder, countOfPerson, random);
        this.names = names;
    }
}
