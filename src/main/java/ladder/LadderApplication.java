package ladder;

import ladder.model.Ladder;
import ladder.generator.RandomBooleanGenerator;
import ladder.model.Rewards;
import ladder.model.Users;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;


public class LadderApplication {
    public static void main(String[] args) {
        List<String> userNames = InputView.inputUserNames();
        List<String> inputRewards = InputView.inputRewards();
        int ladderHeight = InputView.inputLadderHeight();

        Users users = Users.of(userNames);
        Ladder ladder = Ladder.of(users.size(), ladderHeight, new RandomBooleanGenerator());
        Rewards rewards = Rewards.of(users.size(), inputRewards);

        ResultView.showResult(users, ladder, rewards);
    }
}
