package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Names;
import nextstep.ladder.domain.strategy.RandomLadderPoint;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {
    public static void main(String[] args) {
        Names names = InputView.inputNames();
        Height height = InputView.inputHeight();

        LadderGame ladderGame = new LadderGame(names, new RandomLadderPoint(), height);

        OutputView.printNamesAndLadders(ladderGame);
    }
}
