package nextstep.ladder.view;

import nextstep.ladder.domain.*;
import nextstep.ladder.util.LadderUtils;

import java.util.List;

import static nextstep.ladder.constant.PrintMessage.PRINT_TEXT_LADDER_RESULT;
import static nextstep.ladder.constant.PrintMessage.PRINT_TEXT_REWARD_RESULT;

public class ResultView {

    private final String UNIT_LADDER_CHARACTOR = "|";
    private final String UNIT_BRIDGE_CHARACTOR = "-----";
    private final String UNIT_EMPTY_BRIDGE_CHARACTOR = "     ";
    private final String NAME_FIXED_SIX_SPACE = "      ";
    private final String FIELD_SEPERATOR_COLON = " : ";

    public void showLadderResult(Users users, Ladder ladder, Rewards rewards) {
        System.out.println(PRINT_TEXT_LADDER_RESULT);
        printUsers(users);
        printLadder(ladder);
        printReward(rewards);
    }

    public void showLadderGameResult(LadderResultBoard positionBoard, Rewards rewards) {
        System.out.println(PRINT_TEXT_REWARD_RESULT);


        StringBuilder sb = new StringBuilder();

        for(User user : positionBoard.users()){
            sb.append(user.getUserName())
                .append(FIELD_SEPERATOR_COLON)
                .append(rewards.getReward(user.getPosition()).getName())
                .append("\n");
        }
        System.out.println(sb.toString());
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
            System.out.println(printBridge(line));
        }
    }

    private String printBridge(Line line) {

        List<Boolean> points = line.getPoints();
        StringBuilder sb = new StringBuilder();
        sb.append(UNIT_LADDER_CHARACTOR);

        boolean isOpenBridge = false;
        for(int i = 0; i < points.size() - 1; i++) {

            isOpenBridge = LadderUtils.isOpenBridge(isOpenBridge,points.get(i));

            sb.append(printBridge(points.get(i), isOpenBridge));
            sb.append(UNIT_LADDER_CHARACTOR);
        }

        return sb.toString();
    }


    private String printBridge(boolean isBridge, boolean isOpen) {
        return (isBridge && isOpen )? UNIT_BRIDGE_CHARACTOR : UNIT_EMPTY_BRIDGE_CHARACTOR;
    }

    private String getFixedLengthName(String name) {
        StringBuilder fixedLengthName = new StringBuilder();
        String newPrefix = NAME_FIXED_SIX_SPACE.substring(name.length());
        fixedLengthName.append(name).append(newPrefix);

        return fixedLengthName.toString();
    }
}
