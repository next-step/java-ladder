package nextstep.step2;

import nextstep.step2.domain.Ladder;
import nextstep.step2.domain.ParticipantNames;
import nextstep.step2.view.InputView;
import nextstep.step2.view.OutputView;

public class LadderGameApplication {

    public static void main(String[] args) {
        ParticipantNames participantNames = ParticipantNames.from(InputView.inputParticipantNames());
        int ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = Ladder.of(participantNames, ladderHeight);
        OutputView.printGameResult(ladder);
    }
}
