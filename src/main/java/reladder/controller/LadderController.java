package reladder.controller;

import reladder.domain.*;
import reladder.service.LadderGame;

public class LadderController {

    public LadderGame execute(String names, int height, String result) {

        MatchUp matchUp = new MatchUp(names, result);
        Ladder ladder = new DefaultLadderGenerator().generate(height, matchUp.getPeopleCount());
        return new LadderGame(ladder, matchUp);
    }
}
