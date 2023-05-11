package nextstep;

import nextstep.domain.Ladder;
import nextstep.view.InputView;

public class LadderGame {

    public static void main(String[] args) {
        String[] participants = InputView.participants();
        int height = InputView.height();

        Ladder ladder = Ladder.makeLadder(height, participants.length);
    }
}
