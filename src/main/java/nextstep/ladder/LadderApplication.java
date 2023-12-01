package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.domain.strategy.RandomLineStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        String inputNames = InputView.inputNames();
        PersonNames personNames = new PersonNames(inputNames);
        int inputHeight = InputView.inputHeight();
        Height height = new Height(inputHeight);
        String inputAmounts = InputView.inputAmounts();
        ResultAmounts resultAmounts = new ResultAmounts(inputAmounts);
        Ladder ladder = new Ladder(personNames, height, new RandomLineStrategy());
        OutputView.printLadder(personNames, ladder, resultAmounts);
    }
}
