package ladder.controller;

import ladder.domain.GameResult;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResultController {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final Players players;
    private final GameResult gameResult;

    public GameResultController(Players players, GameResult gameResult) {
        this.players = players;
        this.gameResult = gameResult;
    }

    public void printResult() {
        while (true) {
            String input = inputView.getWantResult();
            if (input.equals("all")) {
                printAllResult();
            } else {
                printPlayerResult(input);
            }
        }
    }

    private void printAllResult() {
        String result = IntStream.range(0, players.size())
                .mapToObj(idx -> players.getName(idx) + " : " + gameResult.getResultName(idx))
                .collect(Collectors.joining("\n"));
        resultView.printGameResult(result);
    }

    private void printPlayerResult(String name) {
        int playerIdx = players.findIndexByName(name)
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 플레이어는 존재하지 않습니다."));
        String result = gameResult.getResultName(playerIdx);
        resultView.printGameResult(result);
    }
}
