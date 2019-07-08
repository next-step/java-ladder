package ladder.controller;

import ladder.model.Ladder;
import ladder.model.Result;
import ladder.model.User;
import ladder.model.Users;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderMain {

    public static void main(String[] arg) {
        String ladderUserNames = InputView.inputLadderUser();
        Users users = new Users(ladderUserNames);

        String ladderResultItem = InputView.inputResultItem();
        Result result = new Result(users, ladderResultItem);

        String ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = new Ladder(users.userCount(), ladderHeight);

        OutputView.printLadderUser(users, result.maxLadderTextCount());
        OutputView.printLadder(ladder);
        OutputView.printResultItem(result);

        User resultViewUser;
        while (true) {
            resultViewUser = new User(InputView.inputResultUser());
            if (resultViewUser.isAllPrintSignUser()) {
                OutputView.printAllUserReust(result, users, ladder);
                break;
            }
            OutputView.printUserResult(result, resultViewUser, ladder);
        }

    }

}