package nextstep.step2;

import nextstep.step2.domain.Lines;
import nextstep.step2.view.InputView;
import nextstep.step2.view.OutputView;

public class Application {

    public static void main(String[] args) {
        final var participants = InputView.inputParticipantPeople();
        final var ladderHeight = InputView.inputLadderHeight();
        final var lines = new Lines(participants.count(), ladderHeight);

        OutputView.printResult(participants, lines);
    }
}
