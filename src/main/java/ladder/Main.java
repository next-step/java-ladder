package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {
    private static final String ALL_PLAYERS = "all";

    public static void main(String[] args) {
        Players players = new Players(InputView.printPlayers());
        Rewards rewards = new Rewards(InputView.printRewards(), players.getPlayersCount());
        Height height = new Height(InputView.printHeight());

        LadderGame ladderGame = LadderGame.init(players, rewards, height, new RandomPointGenerationStrategy());

        OutputView.printResult(players, rewards, ladderGame.getLadder());

        while(true) {
            String name = InputView.printResult();

            if(name.equals(ALL_PLAYERS)) {
                GameResult result = ladderGame.playAll();
                OutputView.printAllReward(result);
                break;
            }

            OutputView.printReward(ladderGame.playOne(name));
        }
    }
}
