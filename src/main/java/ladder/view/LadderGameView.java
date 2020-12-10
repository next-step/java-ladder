package ladder.view;

import ladder.dto.LadderGameResult;

public class LadderGameView {

    public static String enterParticipants() {
        return InputView.enterParticipants();
    }

    public static int enterMaxLadderHeight() {
        return InputView.enterMaxLadderHeight();
    }

    public static void printLadders(LadderGameResult ladderGameResult) {
        ResultView.printResult(ladderGameResult.getLadder(), ladderGameResult.getNames());
    }
}
