package nextstep.controller;

import nextstep.domain.StartLadderGame;
import nextstep.domain.Users;
import nextstep.view.InputView;
import nextstep.view.ResultView;

public class LadderGame {

    private static final String USER_ALL = "all";

    public static void main(String[] args) {
        Users users = InputView.inputUserName();
        StartLadderGame startLadderGame = new StartLadderGame(users, InputView.createLadder(users.getUserSize()));
        ResultView.print(startLadderGame);

        while(true) {
            String userName = InputView.inputLadderResultUserName();
            if(userName.equals(USER_ALL)) {
                ResultView.printAllResult(users, startLadderGame.findAll());
                break;
            }
            ResultView.printUserResult(startLadderGame.findUserResult(userName));
        }
    }

}
