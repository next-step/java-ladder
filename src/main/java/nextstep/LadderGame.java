package nextstep;

import nextstep.domain.Ladder;
import nextstep.domain.Participants;
import nextstep.view.InputView;

public class LadderGame {

    public static void main(String[] args) {
        String[] participants = InputView.participants();
        int height = InputView.height();

        Participants part = Participants.participate(participants);
        Ladder ladder = Ladder.makeLadder(height, participants.length);
    }
}
