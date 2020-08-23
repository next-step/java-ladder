package camp.nextstep.edu.rebellion;

import camp.nextstep.edu.rebellion.domain.ladder.Ladder;
import camp.nextstep.edu.rebellion.domain.LadderGame;
import camp.nextstep.edu.rebellion.domain.player.Players;
import camp.nextstep.edu.rebellion.domain.reward.Rewards;
import camp.nextstep.edu.rebellion.domain.rule.RandomDrawingRule;
import camp.nextstep.edu.rebellion.view.InputView;
import camp.nextstep.edu.rebellion.view.ResultView;

public class LadderGameRunner {
    public static void main(String[] args) {
        Players players = new Players(InputView.getPlayers());
        Rewards rewards = new Rewards(InputView.getRewards());
        int rows = InputView.getRows();

        LadderGame ladderGame = new LadderGame(players, rewards, rows);
        Ladder ladder = ladderGame.make(new RandomDrawingRule());

        ResultView.printAll(players, rewards, ladder);

        String name = InputView.getPlayerOrCommandForResult();
        ResultView.printRewardResults(ladderGame.run(name));
    }
}
