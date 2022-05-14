package nextstep.controller;

import nextstep.domain.Ladder;
import nextstep.domain.StartLadderGame;
import nextstep.domain.Users;
import nextstep.view.InputView;
import nextstep.view.ResultView;

public class LadderGame {
    public static void main(String[] args) {
        Users users = InputView.inputUserName();
        StartLadderGame startLadderGame = new StartLadderGame(users
                , new Ladder(users.getUserSize()
                , InputView.inputMaxLadderHeight()
                , InputView.inputLadderResult()));
        ResultView.print(startLadderGame);

        while(true) {
            String userName = InputView.inputLadderResultUserName();
            if(userName.equals("all")) {
                ResultView.printAllResult(users, startLadderGame.findAll());
                break;
            }
            ResultView.printUserResult(startLadderGame.findUserResult(userName));
        }
    }

}
