package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.PersonNames;
import nextstep.ladder.domain.strategy.RandomLine;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        String inputNames = InputView.inputNames();
        PersonNames personNames = new PersonNames(inputNames);
        int inputHeight = InputView.inputHeight();
        Ladder ladder = new Ladder(personNames.size(), inputHeight, new RandomLine());
        OutputView.printLadder(personNames, ladder);
    }
}
