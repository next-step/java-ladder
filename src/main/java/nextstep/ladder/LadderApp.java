package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderApp {
    public static void main(String[] args) {
        Participants participants = new Participants(InputView.inputParticipants());
        final String ladderResult = InputView.inputLadderResult();

        Ladder ladder = new Ladder(participants, InputView.inputLadderHeight());

        ResultView.print(ladder.toString());
    }
}
