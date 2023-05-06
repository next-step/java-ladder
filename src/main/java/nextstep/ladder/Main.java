package nextstep.ladder;

import nextstep.ladder.domain.Heights;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.RandomDrawStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Participants participants = InputView.inputNames();
        Heights heights = InputView.inputHeights();

        Ladder ladder = Ladder.from(heights, participants, new RandomDrawStrategy());
        OutputView.printLadder(participants, ladder);
    }
}
