package ladder.view;

import ladder.domain.Ladders;

import java.util.List;

public class LadderGameView {

    public static String enterParticipants() {
        return InputView.enterParticipants();
    }

    public static int enterMaxLadderHeight() {
        return InputView.enterMaxLadderHeight();
    }

    public static void printLadders(Ladders ladders, List<String> participants) {
        ResultView.printResult(ladders, participants);
    }
}
