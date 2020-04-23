package ladder.ui;

import ladder.application.LadderGame;
import ladder.domain.*;
import ladder.dto.LadderRequest;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderController {
    private static final String TARGET_ALL = "all";
    private static final String SEPARATOR = ",";

    public static void main(String[] args) {
        LadderRequest ladderRequest = InputView.inputLadderInfo();
        Users users = Users.of(ladderRequest.getUserNames(), SEPARATOR);
        List<LadderReward> ladderRewards = rewardsToLadderRewards(ladderRequest.getRewards());
        LadderGameInfo ladderGameInfo = new LadderGameInfo(users, ladderRewards);

        Ladder ladder = LadderGame.createLadder(users.size(), ladderRequest.getHeight());
        LadderGameResults results = LadderGame.start(ladder, ladderGameInfo);

        ResultView.print(ladder, ladderGameInfo);
        String inputTarget = InputView.inputTarget();
        while (TARGET_ALL.equals(inputTarget)) {
            inputTarget = InputView.inputTarget();
            ResultView.printResult(inputTarget, results);
        }
    }

    private static List<LadderReward> rewardsToLadderRewards(String rewards) {
        return Arrays.stream(rewards.split(SEPARATOR))
                .map(LadderReward::new)
                .collect(Collectors.toList());
    }
}
