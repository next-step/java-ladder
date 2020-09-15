package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    public static void main(String...args) {
        InputView inputView = new InputView();

        Users users = new Users(inputView.joinUser());
        Rewards rewards = new Rewards(inputView.inputGameResult(), users.getUserCount());
        Height height = new Height(inputView.ladderHeight());

        Ladder ladder = new Ladder(users.getUserCount(), height);
        ResultView.resultLadderGame(users.getUsers(), ladder, rewards);

        Map<User, Reward> userRewardMap = new HashMap<>();
        for(User user : users.getUsers()) {
            int position = ladder.downLadder(user.getPosition());
            Reward reward = rewards.setRewardPosition(position);
            userRewardMap.put(user, reward);
        }
        Result result = new Result(userRewardMap);

        ResultView.printWhoGetPrize(inputView.seeResult(), result);
    }
}
