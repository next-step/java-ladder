package nextstep.ladder;

import java.util.List;

public class LadderGame {

    public static void run() {
        List<String> participantsName = getParticipants();
        int height = getLadderHeight();

        List<Line> ladder = Ladder.of(participantsName, height);

        OutputView.printLadder(participantsName,ladder);
    }

    private static int getLadderHeight() {
        OutputView.printAskLadderHeightMessage();
        return InputView.getLadderHeight();
    }

    private static List<String> getParticipants() {
        OutputView.printParticipantsMessage();
        return InputView.getParticipantsName();
    }
}
