package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String[] userNames = inputView.inputUserNames();
        Integer ladderHeight = inputView.inputLadderHeight();

        Ladder ladder = new Ladder(ladderHeight, userNames.length);

        resultView.printResult(userNames, ladder.getLadder());
    }
}
