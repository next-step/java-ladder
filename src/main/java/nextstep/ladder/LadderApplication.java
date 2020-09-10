package nextstep.ladder;

import nextstep.ladder.domain.line.LadderLines;
import nextstep.ladder.domain.result.LadderResult;
import nextstep.ladder.domain.result.Results;
import nextstep.ladder.domain.user.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        String joinUsers = InputView.inputGameUser();

        Users users = LadderAdministrator.userManagement(joinUsers);
        int countOfUser = users.size();

        Results results = new Results(InputView.inputLadderResult());

        int height = InputView.inputLadderHeight();

        LadderResult ladderResult = LadderAdministrator.ladderResultManagement(users);
        LadderLines ladderLines = LadderAdministrator.ladderLinesManagement(ladderResult, height, countOfUser);

        ResultView.printLadderGame(users, ladderLines, results, ladderResult);
    }

}
