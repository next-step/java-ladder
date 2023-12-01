package ladder.controller;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {

    public static void main(String[] args) {
        List<Player> players = InputView.inputPlayers();
        List<Prize> prizes = InputView.inputLadderPrizes();
        int lineHeight = InputView.inputLadderHeight();

        List<Line> lines = LadderGame.start(lineHeight, players.size(), new PointRandomStrategy());
        OutputView.viewLadder(lines, players, prizes);

        LadderGame gameResult = LadderGame.result(players, lines, prizes);
        Player player = InputView.inputLadderResultPlayer(players);

        OutputView.getLadderResult(player, gameResult);
    }
}
