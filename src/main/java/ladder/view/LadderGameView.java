package ladder.view;

import ladder.domain.Ladder;
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

    public static void printLadders(Ladder ladder, LadderGameResult ladderGameResult) {
        ResultView.printLadders(ladder, ladderGameResult);
        ResultView.printResult(ladderGameResult.getResults());
    }

    public static String enterLadderGameResult() {
        return InputView.enterLadderGameResult();
    }
}
