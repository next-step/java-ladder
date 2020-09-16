package laddergame.domain.manager;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.player.Player;
import laddergame.domain.utils.Constants;
import laddergame.view.InputView;
import laddergame.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameManager {

    private List<Player> players;

    GameManager() {
        players = new ArrayList<>();
        this.startGame(this.readyGame());
    }

    private int readyGame() {
        Arrays.stream(InputView.getPlayerNames().split(Constants.PLAYER_NAME_SEPERATOR))
                .forEach(playerName -> players.add(new Player(playerName)));

        return InputView.getMaxLadderHeight();
    }

    private void startGame(int maxHeight) {
        ResultView.showResult();
        ResultView.showPlayers(players);
        ResultView.showLadder(new Ladder(maxHeight, players.size()));
    }

}
