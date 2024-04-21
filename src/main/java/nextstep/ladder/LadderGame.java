package nextstep.ladder;

import nextstep.ladder.domain.GameUsers;
import nextstep.ladder.domain.LadderBoard;
import nextstep.ladder.domain.LadderGameResult;
import nextstep.ladder.domain.UserNames;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderGame {
    private static final String QUIT_RESULT_VIEW = "q";
    private static final String ALL_RESULT_VIEW = "all";

    public static void start() {
        UserNames userNames = new UserNames(InputView.InputNames());
        List<String> executionResult = InputView.InputExecutionResult();
        int ladderHeight = InputView.InputLadderHeight();

        GameUsers gameUsers = new GameUsers(userNames);

        LadderBoard ladderBoard = new LadderBoard(ladderHeight, userNames.size());
        gameUsers.moveAllUsersOnLadderBoard(ladderBoard);

        LadderGameResult result = gameUsers.makeResult(executionResult);

        ResultView.printNames(userNames);
        ResultView.printLadderBoard(ladderBoard);
        ResultView.printLadderGameResult(executionResult);

        while (true) {
            String interestedPerson = InputView.inputInterestedPerson();
            if (interestedPerson.equals(QUIT_RESULT_VIEW)) {
                return;
            }
            if (interestedPerson.equals(ALL_RESULT_VIEW)) {
                ResultView.printResultPerson(result);
            } else {
                ResultView.printResultSinglePerson(result.getSingleResult(interestedPerson));
            }
        }
    }

}
