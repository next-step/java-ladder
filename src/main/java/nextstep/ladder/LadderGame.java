package nextstep.ladder;

import nextstep.ladder.domain.line.LadderLines;
import nextstep.ladder.domain.line.LadderLineGenerator;
import nextstep.ladder.domain.point.RightPointRandomStrategy;
import nextstep.ladder.domain.result.LadderResult;
import nextstep.ladder.domain.result.Results;
import nextstep.ladder.domain.user.UserGenerator;
import nextstep.ladder.domain.user.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {

    public static void main(String[] args) {
        String joinUsers = InputView.inputGameUser();

        Users users = Users.from(UserGenerator.generateUsers(joinUsers));
        int countOfUser = users.size();

        Results results = new Results(InputView.inputLadderResult());

        int height = InputView.inputLadderHeight();
        LadderLines ladderLines = LadderLineGenerator.generateLadderLine(height, countOfUser, new RightPointRandomStrategy());

        LadderResult ladderResults = new LadderResult(users.getUsers());
        ladderLines.goDownALadder(ladderResults.getLadderResult());

        ResultView.printLadderResult(users.getUsers(), ladderLines, results.getResults());

        ResultView.printGameResult(ladderResults.getLadderResult(), results.getResults());
    }

}
