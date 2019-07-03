package ladderGame;

import ladderGame.domain.Ladder;
import ladderGame.domain.Players;
import ladderGame.view.InputView;
import ladderGame.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {

        Players players = InputView.aksPlayers();
        int height = InputView.askLadderHeight();
        Ladder ladder = Ladder.of(players.size(), height);

        players.playGame(ladder);

        ResultView.drawLadderAndPlayer(players, ladder);

        System.out.println();
    }
}
