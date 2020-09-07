package nextstep.ladder;

import nextstep.ladder.domain.line.LadderLine;
import nextstep.ladder.domain.line.LadderLineGenerator;
import nextstep.ladder.domain.point.RightPointRandomStrategy;
import nextstep.ladder.domain.result.LadderResult;
import nextstep.ladder.domain.result.Results;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.UserGenerator;
import nextstep.ladder.domain.user.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.Map;

public class LadderGame {

    public static void main(String[] args) {
        String joinUsers = InputView.inputGameUser();

        Users users = Users.from(UserGenerator.generateUsers(joinUsers));
        int countOfUser = users.size();

        Results results = new Results(InputView.inputLadderResult());

        int height = InputView.inputLadderHeight();
        LadderLine ladderLine = LadderLineGenerator.generateLadderLine(height, countOfUser, new RightPointRandomStrategy());

        Map<User, Integer> ladderResults = new LadderResult(users.getUsers()).getLadderResult();
        ladderLine.goDownALadder(ladderResults);

        ResultView.printLadderResult(users.getUsers(), ladderLine, results.getResults());

        ResultView.printGameResult(ladderResults, results.getResults());
    }

}
