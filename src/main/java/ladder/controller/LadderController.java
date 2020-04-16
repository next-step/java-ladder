package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.result.LadderResults;
import ladder.domain.user.UserResult;
import ladder.domain.user.Users;
import ladder.view.LadderInput;
import ladder.view.LadderOutput;

public class LadderController {

    public void start() {
        Users users = new Users(LadderInput.userAdd());
        int height = LadderInput.ladderHeight();
        Ladder ladder = Ladder.of(height, users.countOfUser());
        LadderResults ladderResults = new LadderResults(LadderInput.resultAdd());

        LadderOutput.drawLadderGame(users.showUsers(), ladder.showLadder(), ladderResults.showLadderResults());

        String userNameForResult = LadderInput.checkUserResult();

        while (!userNameForResult.equalsIgnoreCase("all")) {
            UserResult userResult = ladder.playLadderGame(users, userNameForResult);
            LadderOutput.showLadderResult(ladderResults, userResult);
            userNameForResult = LadderInput.checkUserResult();
        }
        LadderOutput.showLadderResultAll(ladderResults, ladder.playLadderGames(users));

    }
}
