package nextstep.ladder.controller;

import nextstep.ladder.domain.Game;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.view.GameResult;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.LadderResult;
import nextstep.ladder.view.ResultView;

public class LadderController {
    public void start() {
        String[] inputNames = InputView.inputNames();

        Players players = Players.create(inputNames);
        String[] results = InputView.inputResults();
        int height = InputView.inputLadderHeight();

        Game game = new Game(players, results, height);
        ResultView.showLadder(new LadderResult(game, results));

        GameResult gameResult = new GameResult(game);
        showGameResult(gameResult);
    }

    private void showGameResult(GameResult gameResult) {
        String playerName = InputView.inputPlayerName();

        if (playerName.equals("all")) {
            String result = gameResult.resultOfPlayer(playerName);
            ResultView.showResult(result);
            return;
        }

        String result = gameResult.resultOfPlayer(playerName);
        if (result == null) {
            System.out.println(result + "은(는) 등록되지 않은 플레이어 입니다.");
            return;
        }

        ResultView.showResult(result);
        showGameResult(gameResult);
    }
}
