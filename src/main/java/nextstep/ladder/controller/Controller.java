package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Controller {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputNames();
        inputView.inputHeight();

        Users users = new Users(inputView.getUserNames());
        Ladder ladder = new Ladder(inputView.getLadderHeight(), users.getUserCount());

        ResultView resultView = new ResultView();
        resultView.printResult(users.getUserNames(), ladder.getLines());
    }
}
