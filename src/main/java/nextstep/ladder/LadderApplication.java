package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.PersonNames;
import nextstep.ladder.domain.strategy.RandomLineStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        String inputNames = InputView.inputNames();
        PersonNames personNames = new PersonNames(inputNames);
        int inputHeight = InputView.inputHeight();
        Height height = new Height(inputHeight);
        Ladder ladder = new Ladder(personNames, height, new RandomLineStrategy());
        OutputView.printLadder(personNames, ladder);
    }
}
