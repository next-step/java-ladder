package nextstep.ladder.domain;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderRewardBoard {

    private LadderPositionBoard ladderPositionBoard;
    private Rewards rewards;

    public LadderRewardBoard(LadderPositionBoard ladderPositionBoard, Rewards rewards) {
        this.ladderPositionBoard = ladderPositionBoard;
        this.rewards = rewards;
    }

    public static LadderRewardBoard create(LadderPositionBoard ladderPositionBoard, Rewards rewards) {
        return new LadderRewardBoard(ladderPositionBoard, rewards);
    }

    public String showUserReward(String userName) {
        if("all".equalsIgnoreCase(userName)){
            return showAllReward();
        }
        User user = ladderPositionBoard.resultUserPosition(userName);
        int resultPosition = user.getPosition();
        return rewards.getReward(resultPosition).getName();
    }

    public String showAllReward() {

        return ladderPositionBoard.users().stream()
                .map(user -> user.getUserName() + " : "+ rewards.getReward(user.getPosition()).getName())
                .collect(Collectors.joining("\n"));

    }

}
