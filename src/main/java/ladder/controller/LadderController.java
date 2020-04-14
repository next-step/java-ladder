package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.user.Users;
import ladder.view.LadderInput;
import ladder.view.LadderOutput;

public class LadderController {

    public void start() {
        Users users = new Users(LadderInput.userAdd());
        int height = LadderInput.ladderHeight();
        Ladder ladder = Ladder.of(height, users.countOfUser());

        LadderOutput.drawLadderGame(users.showUsers(), ladder.getLadder());
    }
}
