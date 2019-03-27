package laddergame;

import laddergame.domain.EndPoints;
import laddergame.domain.LadderLines;
import laddergame.domain.Result;
import laddergame.view.InputView;
import laddergame.view.ResultView;

public class ApplicationLauncher {
    public static final String ALL = "all";

    public static void main(String[] args) {
        EndPoints participants = InputView.getParticipants();
        EndPoints rewards = InputView.getRewards();
        int maximumHeight = InputView.getMaximumHeight();

        LadderLines ladderLines = new LadderLines(participants.size(), maximumHeight);
        Result result = new Result(participants, ladderLines, rewards);

        ResultView.showLadderLines(result);
        showRewardResult(result);
    }

    private static void showRewardResult(Result result) {
        String key;
        do {
            key = InputView.getRewardResultKey();
            ResultView.showRewardResult(result, key);
        } while(!ALL.equals(key));
    }
}