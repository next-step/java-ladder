package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.domain.strategy.RandomLadderPoint;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderController {
    public static void main(String[] args) {
        Names names = InputView.inputNames();
        List<LadderResult> inputLadderResults = InputView.inputLadderResults();
        Height height = InputView.inputHeight();
        Lines lines = new Lines();
        lines.initialize(names.size(), height, new RandomLadderPoint());

        OutputView.printNames(names);
        OutputView.printLadders(lines);
        OutputView.printInputResults(inputLadderResults);

        LadderGame ladderGame = new LadderGame(names, lines, inputLadderResults);

//        OutputView.printNamesAndLadders(ladderGame);
//        OutputView.printInputResults(inputLadderResults);
    }
}
