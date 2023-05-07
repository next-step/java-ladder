package nextstep.ladder;

import nextstep.ladder.domain.Heights;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderInputs;
import nextstep.ladder.domain.RandomDrawStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        LadderInputs participants = InputView.inputNames();
        LadderInputs results = InputView.inputResults(participants);
        Heights heights = InputView.inputHeights();

        Ladder ladder = Ladder.from(heights, participants, new RandomDrawStrategy());
        OutputView.printLadder(participants, ladder);
    }
}
