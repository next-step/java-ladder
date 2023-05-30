package nextstep.step2;

import nextstep.step2.domain.Ladder;
import nextstep.step2.domain.ResultMatcher;
import nextstep.step2.view.InputView;
import nextstep.step2.view.OutputView;

public class Application {

    public static void main(String[] args) {
        final var participants = InputView.inputParticipantPeople();
        final var result = InputView.inputResult();
        final var ladderHeight = InputView.inputLadderHeight();

        final var lines = new Ladder(participants, ladderHeight);

        OutputView.printLadderResult(participants, lines, result);

        final var name = InputView.participant();

        final var matcher = new ResultMatcher(lines, result);

        OutputView.ladderGameResult(participants, matcher, name);
    }
}
