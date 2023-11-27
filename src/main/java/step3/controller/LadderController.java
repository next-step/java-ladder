package step3.controller;

import step3.model.LadderGame;
import step3.model.Player;
import step3.model.Prize;
import step3.model.Result;
import step3.view.InputView;
import step3.view.OutputView;

import java.util.List;
import java.util.Map;

public class LadderController {

    public static void main(String[] args) {
        List<Player> players = InputView.inputPlayers();

        int lineHeight = InputView.inputLadderHeight();
        List<Prize> prizes = InputView.inputLadderPrizes();
        Player player = InputView.inputLadderResultPlayer();

        LadderGame ladderGame = new LadderGame(lineHeight, players.size());
        OutputView.viewLadder(ladderGame, players, prizes);

        Result result = Result.of(players, prizes, ladderGame);
        OutputView.viewResult(result);
    }
}
