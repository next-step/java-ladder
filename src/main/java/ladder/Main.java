package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Map;

public class Main {
    private static final String GAME_END_KEYWORD = "all";

    public static void main(String[] args) {
        Players players = new Players(InputView.printPlayers());
        Rewards rewards = new Rewards(InputView.printRewards(), players.getPlayersCount());
        Height height = new Height(InputView.printHeight());

        LadderGame ladderGame = LadderGame.init(players, rewards, height, new RandomPointGenerationStrategy());

        OutputView.printResult(players, rewards, ladderGame.getLadder());

        while(true) {
            String name = InputView.printResult();

            if(name.equals(GAME_END_KEYWORD)) {
                Map<String, Reward> result = ladderGame.playAll();
                OutputView.printAllReward(result);
                break;
            }

            OutputView.printReward(ladderGame.playOne(name));
        }
    }
}
