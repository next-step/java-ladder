package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Users;

public class LadderController {

    // todo
    public Ladder run(RunRequest request) {
        Users users = request.participatedUsers();
        return Ladder.initate(users.size(), request.getHeightOfLadder());
    }
}
