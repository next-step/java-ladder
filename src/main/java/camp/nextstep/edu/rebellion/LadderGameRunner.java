package camp.nextstep.edu.rebellion;

import camp.nextstep.edu.rebellion.domain.reward.RewardResults;
import camp.nextstep.edu.rebellion.game.LadderGame;
import camp.nextstep.edu.rebellion.domain.player.Players;
import camp.nextstep.edu.rebellion.domain.reward.Rewards;
import camp.nextstep.edu.rebellion.game.LadderGameFactory;
import camp.nextstep.edu.rebellion.game.LadderGameMode;
import camp.nextstep.edu.rebellion.view.InputView;
import camp.nextstep.edu.rebellion.view.PrintableLadder;
import camp.nextstep.edu.rebellion.view.ResultView;

public class LadderGameRunner {
    public static void main(String[] args) {
        LadderGameMode mode = LadderGameMode.of(InputView.getGameMode());

        Players players = new Players(InputView.getPlayers());
        Rewards rewards = new Rewards(InputView.getRewards());
        int rows = InputView.getRows();

        LadderGame ladderGame = LadderGameFactory.resolve(mode, players, rows);

        PrintableLadder ladder = ladderGame.makePrintableLadder();
        ResultView.printAll(players, rewards, ladder);

        String name = InputView.getPlayerOrCommandForResult();
        ResultView.printRewardResults(RewardResults.of(rewards, ladderGame.run(name)));
    }
}
