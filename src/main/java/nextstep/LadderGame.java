package nextstep;

import nextstep.domain.Ladder;
import nextstep.domain.Participants;
import nextstep.view.InputView;
import nextstep.view.PrintView;

public class LadderGame {

    public static void main(String[] args) {
        String[] splitedParticipants = InputView.participants();
        int height = InputView.height();

        Participants participants = Participants.participate(splitedParticipants);
        Ladder ladder = Ladder.makeLadder(height, participants.count());

        PrintView.printResult(participants, ladder);
    }
}
