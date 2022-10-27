package nextstep.step2;

import nextstep.step2.domain.ParticipantNames;
import nextstep.step2.view.InputView;

public class LadderGameApplication {

    public static void main(String[] args) {
        ParticipantNames participantNames = ParticipantNames.from(InputView.inputParticipantNames());
        InputView.inputLadderHeight();
    }
}
