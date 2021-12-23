package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;

public class LadderController {

    // todo
    public Ladder createLadder(CreateLadderRequest request) {
        return Ladder.initate(request.getUserSize(), request.getHeightOfLadder());
    }
}
