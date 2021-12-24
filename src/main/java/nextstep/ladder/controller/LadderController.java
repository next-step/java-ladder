package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.UserResults;

public class LadderController {

    public Ladder createLadder(CreateLadderRequest request) {
        return Ladder.initate(request.getUserSize(), request.getHeightOfLadder());
    }

    public UserResults retrieveUserResults(RetrieveResultRequest request) {
        return UserResults.from(null);
    }
}
