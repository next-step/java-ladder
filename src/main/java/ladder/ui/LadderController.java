package ladder.ui;

import ladder.application.LadderGame;
import ladder.domain.*;
import ladder.dto.LadderInfoRequest;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderController {
    private static final String TARGET_ALL = "all";
    private static final String SEPARATOR = ",";

    public static void main(String[] args) {
        LadderInfoRequest ladderInfoRequest = InputView.inputLadderInfo();
        List<User> users = userNamesToUsers(ladderInfoRequest.getUserNames());
        List<LadderReward> ladderRewards = rewardsToLadderRewards(ladderInfoRequest.getRewards());
        LadderGameInfo ladderGameInfo = new LadderGameInfo(users, ladderRewards);
        LadderInfo ladderInfo = new LadderInfo(users.size(), ladderInfoRequest.getHeight());

        Ladder ladder = LadderGame.createLadder(ladderInfo);
        LadderGameResults results = LadderGame.start(ladder, ladderGameInfo);

        ResultView.print(ladder, ladderGameInfo);
        String inputTarget = InputView.inputTarget();
        while (TARGET_ALL.equals(inputTarget)) {
            inputTarget = InputView.inputTarget();
            ResultView.printResult(inputTarget, results);
        }
    }

    private static List<User> userNamesToUsers(String userNames) {
        return Arrays.stream(userNames.split(SEPARATOR))
                .map(User::new)
                .collect(Collectors.toList());
    }

    private static List<LadderReward> rewardsToLadderRewards(String rewards) {
        return Arrays.stream(rewards.split(SEPARATOR))
                .map(LadderReward::new)
                .collect(Collectors.toList());
    }
}
