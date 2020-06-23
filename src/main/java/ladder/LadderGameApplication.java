package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderResultOutput;
import ladder.domain.Rewards;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.PlayerResultView;
import ladder.view.ResultView;

public class LadderGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String inputPlayers = inputView.displayIntroUI();
        Players players = new Players(inputPlayers);

        String reulstsString = inputView.displayLadderReulstInputUI();
        Rewards rewards = new Rewards(reulstsString);

        int ladderHeight = inputView.displayLadderHeightInputUI();
        ResultView resultView = new ResultView();

        resultView.displayLadderplayers(players);
        Ladder ladder = new Ladder(ladderHeight, players.getPlayerCount());
        resultView.displayLadder(ladder);
        resultView.displayLadderReulst(rewards);

        new PlayerResultView(ladder.playLadderGame(players, rewards)).displayPlayerResult();

    }

}
