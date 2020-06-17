package ladder;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String inputPlayers = inputView.displayIntroUI();
        Players players = new Players(inputPlayers);
        int ladderHeight = inputView.displayLadderHeightInputUI();
        ResultView resultView = new ResultView();

        resultView.displayLadderplayers(players);
        resultView.displayLadder(new Ladder(ladderHeight, players.getPlayerCount()));

    }

}
