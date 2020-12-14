package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderGameInformation;
import ladder.domain.LadderGameResult;

import java.util.List;

public class LadderGameView {

    public static String enterParticipants() {
        return InputView.enterParticipants();
    }

    public static int enterMaxLadderHeight() {
        return InputView.enterMaxLadderHeight();
    }

    public static void printLadders(LadderGameInformation ladderGameInformation, LadderGameResult ladderGameResult) {
        ResultView.printLadders(ladderGameInformation, ladderGameResult);
    }

//    public static void printLadder(Ladder ladder, List<String> participants) {
//        ResultView.printResult(ladder, participants);
//    }

    public static String enterLadderGameResult() {
        return InputView.enterLadderGameResult();
    }
}
