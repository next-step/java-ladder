package reladder.controller;

import reladder.domain.*;

public class LadderController {

    public Ladder execute(String names, int height, String result) {

        MatchUp matchUp = new MatchUp(names, result);

        Ladder ladder = new DefaultLadderGenerator().generate(height, matchUp.getPeopleCount());

        return ladder;
    }
}
