package nextstep.ladder.controller;

import nextstep.ladder.StringParser;
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
        Ladder ladder = new Ladder(StringParser.toInteger(inputView.getLadderHeight()), users.getCount());

        ResultView resultView = new ResultView();
        resultView.printResult(users.getNames(), ladder.getLines());
    }
}
