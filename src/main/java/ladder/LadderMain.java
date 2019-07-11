package ladder;

import ladder.domain.LadderGame;
import ladder.domain.LadderResult;
import ladder.domain.Players;
import ladder.domain.Rewards;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderMain {

    public static void main(String[] args) {

        Players players = Players.register(InputView.enterPlayers());
        int heightOfLadder = InputView.enterHeightOfLadder();
        LadderGame ladderGame = new LadderGame(players, heightOfLadder);
        
        Rewards rewards = Rewards.of(InputView.enterResults());
        LadderResult ladderResult = ladderGame.play(rewards);

        ResultView.outputOfLadderGame(ladderGame, rewards);
        ResultView.outputOfLadderResult(ladderResult);

    }
}
