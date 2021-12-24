package nextstep.ladder.controller;

import nextstep.ladder.model.*;

import java.util.Arrays;

public class LadderController {

    public Ladder createLadder(CreateLadderRequest request) {
        return Ladder.initate(request.getUserSize(), request.getHeightOfLadder());
    }

    // todo: 구현 필요
    public UserResults retrieveUserResults(RetrieveResultRequest request) {
        UserResult bang = new UserResult(new User(new UserName("crong")), new LadderResult("꽝"));
        UserResult win1000 = new UserResult(new User(new UserName("pobi")), new LadderResult("1000"));
        return UserResults.from(Arrays.asList(bang, win1000));
    }
}
