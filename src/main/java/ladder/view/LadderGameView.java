package ladder.view;

import ladder.domain.LadderGameInformation;
import ladder.domain.LadderGameResult;

public class LadderGameView {

    private LadderGameView() {
    }

    public static String enterParticipants() {
        return InputView.enterParticipants();
    }

    public static int enterMaxLadderHeight() {
        return InputView.enterMaxLadderHeight();
    }

    public static String enterParticipantName() {
        return InputView.enterName();
    }

    public static void printLadders(LadderGameInformation ladderGameInformation, LadderGameResult ladderGameResult) {
        ResultView.printLadders(ladderGameInformation, ladderGameResult);
        ResultView.printResult(ladderGameResult.getResults());

    }

    public static String enterLadderGameResult() {
        return InputView.enterLadderGameResult();
    }
}
