package ladder;

import ladder.model.*;
import ladder.generator.RandomBooleanGenerator;
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

        LadderGame ladderGame = new LadderGame(ladder, users, rewards);
        List<GameResult> gameResults = ladderGame.play();

        ResultView.showResult(users, ladder, rewards);
        ResultView.showGameResult(gameResults);
    }
}
