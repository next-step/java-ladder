package ladder.controller;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderMain {

    public static void main(String[] arg) {
        String ladderUserNames = InputView.inputLadderUser();
        Users users = new Users(ladderUserNames);

        String ladderResultItem = InputView.inputResultItem();
        LadderResult ladderResult = new LadderResult(users, ladderResultItem);

        String ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = Ladder.of(users.userCount(), ladderHeight);

        OutputView.printLadderUser(users, ladderResult.maxLadderTextCount());
        OutputView.printLadder(ladder);
        OutputView.printResultItem(ladderResult);

        LadderRidResult allUserRidResult = ladderResult.getAllUserResult(users, ladder);
        LadderRidResult userRidResult;
        User resultViewUser;
        while (true) {
            resultViewUser = new User(InputView.inputResultUser());
            if (resultViewUser.isAllPrintSignUser()) {
                OutputView.printAllUserReust(allUserRidResult);
                break;
            }
            userRidResult = ladderResult.getUserResult(resultViewUser, ladder);
            OutputView.printUserResult(userRidResult);
        }

    }

}