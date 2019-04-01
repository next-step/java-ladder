package laddergame;

import laddergame.domain.*;
import laddergame.view.InputView;
import laddergame.view.ResultView;

public class ApplicationLauncher {
    public static final String ALL = "all";

    public static void main(String[] args) {
        EndPoints participants = InputView.getParticipants();
        EndPoints rewards = InputView.getRewards();
        Level level = InputView.getLevel();

        LadderLines ladderLines = new LadderLines(participants.size(), level);

        Result result = LadderGame.play(participants, ladderLines, rewards);
        ResultView.showLadderLineResult(result);
        showRewardResult(result);
    }

    private static void showRewardResult(Result result) {
        String key;
        do {
            key = InputView.getRewardResultKey();
            ResultView.showGameResult(result, key);
        } while(!ALL.equals(key));
    }
}