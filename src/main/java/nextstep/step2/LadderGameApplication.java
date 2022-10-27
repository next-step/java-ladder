package nextstep.step2;

import nextstep.step2.domain.Ladders;
import nextstep.step2.domain.ParticipantNames;
import nextstep.step2.view.InputView;
import nextstep.step2.view.OutputView;

public class LadderGameApplication {

    public static void main(String[] args) {
        ParticipantNames participantNames = ParticipantNames.from(InputView.inputParticipantNames());
        int ladderHeight = InputView.inputLadderHeight();
        Ladders ladders = Ladders.of(participantNames, ladderHeight);
        OutputView.printGameResult(ladders);
    }
}
