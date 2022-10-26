package nextstep.step2;

import java.util.List;
import nextstep.step2.domain.ParticipantName;
import nextstep.step2.view.InputView;

public class LadderGameApplication {

    public static void main(String[] args) {
        List<ParticipantName> participantNames = InputView.inputParticipantNames();
    }
}
