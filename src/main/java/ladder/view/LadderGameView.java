package ladder.view;

import ladder.domain.Ladders;

public class LadderGameView {

    public static String enterParticipants() {
        return InputView.enterParticipants();
    }

    public static int enterMaxLadderHeight() {
        return InputView.enterMaxLadderHeight();
    }

    public static void printLadders(Ladders ladders) {
        ResultView.printResult(ladders);
    }
}
