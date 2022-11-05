package ladder;

import ladder.model.LadderGame;
import ladder.model.LadderRewards;
import ladder.model.Players;

import static ladder.view.InputView.*;
import static ladder.view.OutputView.*;

public class Main {
    public static void main(String[] args) {
        Players players = Players.of(scanPlayersName());

        LadderGame ladderGame = new LadderGame(scanLadderResult(), players.getPlayersCount(), scanLadderHeight());

        showResultMessage();
        showPlayersName(players);
        showLadder(ladderGame);
        showReward(ladderGame.getLadderRewards());

        String player = scanPlayerResult();

        LadderRewards result = ladderGame.getResult();

        players.findPlayerNumber(player).ifPresentOrElse(
                number -> showResultByPlayer(result.get(number), players.getPlayer(number))
                , () -> showResultAll(result, players)
        );
    }
}
