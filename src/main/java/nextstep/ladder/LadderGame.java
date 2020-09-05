package nextstep.ladder;

import nextstep.ladder.domain.line.LadderLineGenerator;
import nextstep.ladder.domain.line.LadderLine;
import nextstep.ladder.domain.point.RightPointRandomStrategy;
import nextstep.ladder.domain.result.Results;
import nextstep.ladder.domain.user.UserGenerator;
import nextstep.ladder.domain.user.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderGame {

    public static void main(String[] args) {
        String joinUsers = InputView.inputGameUser();

        Users users = Users.from(UserGenerator.generateUsers(joinUsers));
        int countOfUser = users.size();

        String ladderResult = InputView.inputLadderResult();
        List<String> results = Results.from(ladderResult);

        int height = InputView.inputLadderHeight();
        LadderLine ladderLine = LadderLineGenerator.generateLadderLine(height, countOfUser, new RightPointRandomStrategy());

        ResultView.printGameResult(users.getUsers(), ladderLine, results);
    }
}
