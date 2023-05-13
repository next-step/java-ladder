package ladder;

import ladder.model.Ladder;
import ladder.generator.RandomBooleanGenerator;
import ladder.model.Users;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;


public class LadderApplication {
    public static void main(String[] args) {
        List<String> userNames = InputView.inputUserNames();
        List<String> rewards = InputView.inputRewards();
        int ladderHeight = InputView.inputLadderHeight();

        Users users = Users.of(userNames);
        Ladder ladder = Ladder.of(users.size(), ladderHeight, new RandomBooleanGenerator());

        ResultView.showResult(users, ladder);
    }
}
