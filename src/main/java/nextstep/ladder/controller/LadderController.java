package nextstep.ladder.controller;

import static nextstep.ladder.view.InputView.inputExecuteResult;
import static nextstep.ladder.view.InputView.inputJoinUserNames;
import static nextstep.ladder.view.InputView.inputLadderHeight;
import static nextstep.ladder.view.InputView.inputUserNameForResult;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.result.LadderResult;
import nextstep.ladder.domain.result.UserResults;
import nextstep.ladder.domain.user.Users;
import nextstep.ladder.view.ResultView;

public class LadderController {

    public void play() {
        Users users = Users.join(inputJoinUserNames());
        LadderResult ladderResult = LadderResult.of(inputExecuteResult());
        Ladder ladder = Ladder.generateLadder(users.numberOfUsers(), inputLadderHeight());
        ResultView.printCreatedLadder(users, ladder);
        ResultView.printLadderResult(ladderResult);
        UserResults userResults = ladder.createUserResults(users, ladderResult);

        ResultView.printUserResults(inputUserNameForResult(), userResults);

    }
}
