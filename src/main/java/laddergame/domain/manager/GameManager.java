package laddergame.domain.manager;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.player.Player;
import laddergame.domain.prize.Prize;
import laddergame.domain.prizecalculator.PrizeCalculator;
import laddergame.domain.utils.Constants;
import laddergame.view.InputView;
import laddergame.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {

    private List<Player> players = new ArrayList<>();
    private List<Prize> prizes = new ArrayList<>();

    GameManager() {
        this.readyGame();
        this.startGame(InputView.getMaxLadderHeight());
        this.calculateResult();
    }

    private void readyGame() {
        players = Arrays.stream(InputView.getPlayerNames().split(Constants.PLAYER_NAME_SEPERATOR))
                .map(Player::new)
                .collect(Collectors.toList());

        prizes = Arrays.stream(InputView.getGameResults().split(Constants.GAME_RESULT_SEPERATOR))
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    private void startGame(int maxHeight) {
        ResultView.showLadderResult();
        ResultView.showPlayers(players);
        ResultView.showLadder(new Ladder(maxHeight, players.size()));
        ResultView.showPrizes(prizes);
    }

    private void calculateResult() {
        String playerName;
        do {
            playerName = InputView.askPlayerName();
            showGamePrize(playerName);
        } while (!playerName.equals(Constants.ALL_PLAYER));
    }

    private void showGamePrize(String playerName) {
        PrizeCalculator prizeCalculator = new PrizeCalculator(prizes);
        if (playerName.equals(Constants.ALL_PLAYER)) {
            ResultView.showGameTotalPrize(prizeCalculator.calculateTotalPrizes(players));
            return;
        }
        ResultView.showGamePrize(prizeCalculator.calculateSinglePrize(playerName));
    }

}
