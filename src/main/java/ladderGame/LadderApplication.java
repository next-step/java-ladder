package ladderGame;

import ladderGame.domain.LadderGame;
import ladderGame.domain.Players;
import ladderGame.view.InputView;
import ladderGame.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {

        Players players = InputView.aksPlayers();
        int height = InputView.askLadderHeight();

        LadderGame ladderGame = new LadderGame(players, height);

        ResultView.drawLadderAndPlayer(players, ladderGame.getLadder());

    }
}
