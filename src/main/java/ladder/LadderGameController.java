package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {
    private static final String ALL = "all";

    public static void main(String[] args) {
        String names = InputView.scanParticipantNames();
        Participants participants = Participants.from(names);

        LadderReward ladderReward = LadderReward.of(participants, InputView.scanLadderReward());

        int ladderHeight = InputView.scanLadderHeight();
        Ladder ladder = Ladder.of(ladderHeight, participants, new LineRandomGenerator());
        OutputView.printLadder(participants, ladder, ladderReward);

        LadderGameResult ladderGameResult = participants.calculateResult(ladder, ladderReward);
        showGameResult(ladderGameResult);
    }

    private static void showGameResult(LadderGameResult ladderGameResult) {
        String wishParticipantName = "";

        while (!ALL.equals(wishParticipantName)) {
            wishParticipantName = InputView.scanWishParticipantName();
            OutputView.printLadderReward(ladderGameResult, wishParticipantName);
        }
    }
}
