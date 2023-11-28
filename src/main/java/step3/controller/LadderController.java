package step3.controller;

import step3.model.*;
import step3.view.InputView;
import step3.view.OutputView;

import java.util.List;

public class LadderController {

    public static void main(String[] args) {
        List<Player> players = InputView.inputPlayers();

        int lineHeight = InputView.inputLadderHeight();
        List<Prize> prizes = InputView.inputLadderPrizes();
        Player player = InputView.inputLadderResultPlayer(players);

        LadderGame ladderGame = LadderGame.start(lineHeight, players.size(), new PointRandomStrategy());
        OutputView.viewLadder(ladderGame, players, prizes);

        Results result = new Results(prizes);
        List<String> ladderResult = result.getLadderResult(player.getName(), players, ladderGame, result);
        OutputView.viewResult(ladderResult);
    }
}
