package ladder.view;

import ladder.domain.LadderGameInformation;
import ladder.domain.LadderGameResult;

import java.util.Map;

public class LadderGameView {

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

    }

    public static void printLadderGameResult(Map<String, String> ladderGameResult) {
        ResultView.printResult(ladderGameResult);
    }

    public static String enterLadderGameResult() {
        return InputView.enterLadderGameResult();
    }
}
