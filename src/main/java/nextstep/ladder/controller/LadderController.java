package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.UserResults;

public final class LadderController {

    private LadderController() {
    }

    public static Ladder createLadder(CreateLadderRequest request) {
        return Ladder.initiate(request.getUserSize(), request.getHeightOfLadder());
    }

    public static UserResults retrieveUserResults(RetrieveResultRequest request) {
        return request.ladderGame()
                .userResults();
    }
}
