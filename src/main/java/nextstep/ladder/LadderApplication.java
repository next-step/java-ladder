package nextstep.ladder;

import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        String participantNames = InputView.readParticipantNames();
        int heightOfLadder = InputView.readHeightOfLadder();
        OutputView.printParticipantNames();
    }
}
