package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.constant.PrintMessage.PRINT_TEXT_LADDER_RESULT;
import static nextstep.ladder.constant.PrintMessage.PRINT_TEXT_REWARD_RESULT;

public class ResultView {

    private final String UNIT_LADDER_CHARACTOR = "|";
    private final String UNIT_BRIDGE_CHARACTOR = "-----";
    private final String UNIT_EMPTY_BRIDGE_CHARACTOR = "     ";
    private final String NAME_FIXED_SIX_SPACE = "      ";

    public void showLadderResult(Users users, Ladder ladder, Rewards rewards) {
        System.out.println(PRINT_TEXT_LADDER_RESULT);
        printUsers(users);
        printLadder(ladder);
        printReward(rewards);
    }

    public void showLadderGameResult(String gameResult) {
        System.out.println(PRINT_TEXT_REWARD_RESULT);
        System.out.println(gameResult);
    }

    private void printReward(Rewards rewards) {
        List<Reward> rewardList = rewards.getRewards();

        String rewardNamesField = rewardList.stream()
                .map(reward -> getFixedLengthName(reward.getName()))
                .reduce("", (rewwardNames, rewardName) -> rewwardNames + rewardName);
        System.out.println(rewardNamesField);
    }

    private void printUsers(Users users) {
        List<User> userList = users.getUsers();

        String userNamesField = userList.stream()
                .map(user -> getFixedLengthName(user.getUserName()))
                .reduce("", (userNames, userName) -> userNames + userName);
        System.out.println(userNamesField);
    }

    private void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLadder();
        for (Line line : lines) {
            String lineString = line.getPoints().stream()
                    .map(point -> printBridge(point))
                    .collect(Collectors.joining(UNIT_LADDER_CHARACTOR, UNIT_LADDER_CHARACTOR, UNIT_LADDER_CHARACTOR));
            System.out.println(lineString);
        }
    }

    private String printBridge(boolean isBridge) {
        return isBridge ? UNIT_BRIDGE_CHARACTOR : UNIT_EMPTY_BRIDGE_CHARACTOR;
    }

    private String getFixedLengthName(String name) {
        StringBuilder fixedLengthName = new StringBuilder();
        String newPrefix = NAME_FIXED_SIX_SPACE.substring(name.length());
        fixedLengthName.append(name).append(newPrefix);

        return fixedLengthName.toString();
    }
}
