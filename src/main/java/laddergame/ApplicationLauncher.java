package laddergame;

import laddergame.domain.EndPoints;
import laddergame.domain.LadderGameResult;
import laddergame.domain.LadderLines;
import laddergame.domain.LadderLineResult;
import laddergame.view.InputView;
import laddergame.view.ResultView;

public class ApplicationLauncher {
    public static final String ALL = "all";

    public static void main(String[] args) {
        EndPoints participants = InputView.getParticipants();
        EndPoints rewards = InputView.getRewards();
        int maximumHeight = InputView.getMaximumHeight();

        LadderLines ladderLines = new LadderLines(participants.size(), maximumHeight);
        LadderLineResult ladderLineResult = new LadderLineResult(participants, ladderLines, rewards);
        ResultView.showLadderLineResult(ladderLineResult);

        LadderGameResult ladderGameResult = new LadderGameResult(participants, ladderLines, rewards);
        showRewardResult(ladderGameResult);
    }

    private static void showRewardResult(LadderGameResult result) {
        String key;
        do {
            key = InputView.getRewardResultKey();
            ResultView.showGameResult(result, key);
        } while(!ALL.equals(key));
    }
}