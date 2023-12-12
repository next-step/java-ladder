package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Names;
import nextstep.ladder.domain.strategy.RandomLadderPoint;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderController {
    public static void main(String[] args) {
        Names names = InputView.inputNames();
        List<LadderResult> inputLadderResults = InputView.inputLadderResults();
        Height height = InputView.inputHeight();

        LadderGame ladderGame = new LadderGame(names);
        ladderGame.initialize(height, new RandomLadderPoint());

        OutputView.printNamesAndLadders(ladderGame);
        OutputView.printInputResults(inputLadderResults);
    }
}
