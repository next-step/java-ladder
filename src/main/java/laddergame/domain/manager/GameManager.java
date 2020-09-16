package laddergame.domain.manager;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.player.Player;
import laddergame.domain.utils.Constants;
import laddergame.view.InputView;
import laddergame.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {

    private List<Player> players = new ArrayList<>();

    GameManager() {
        this.readyGame();
        this.startGame(InputView.getMaxLadderHeight());
    }

    private void readyGame() {
        players = Arrays.stream(InputView.getPlayerNames().split(Constants.PLAYER_NAME_SEPERATOR))
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private void startGame(int maxHeight) {
        ResultView.showResult();
        ResultView.showPlayers(players);
        ResultView.showLadder(new Ladder(maxHeight, players.size()));
    }

}
