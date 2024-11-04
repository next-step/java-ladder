package ladder;

import ladder.domain.BridgeDecision;
import ladder.domain.LadderGame;
import ladder.domain.Players;
import ladder.domain.RandomDecision;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderMain {

    public static void main(String[] args) {
        Players players = new Players(InputView.inputPlayers());

        LadderGame ladderGame = new LadderGame(InputView.inputHeight(), players.size());
        ladderGame.buildLines(new RandomDecision());

        OutputView.print(players.getPlayerNames());
        OutputView.printLadder(ladderGame.getLines());
    }
}
