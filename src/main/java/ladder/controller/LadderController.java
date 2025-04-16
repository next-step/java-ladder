package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderController {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        Players players = new Players(inputView.getPlayers());
        Results results = new Results(inputView.getResults());
        Height height = inputView.getHeight();

        Ladder ladder = new Ladder(height.getLength(), players.countOfPlayer(), results.countOfResult());
        resultView.printResult(players, ladder, results);

        GameResult gameResult = new GameResult(ladder, results);
        printResult(players, gameResult);
    }

    public void printResult(Players players, GameResult gameResult) {
        while (true) {
            String input = inputView.getWantResult();
            branchResultBasedOnInput(input, players, gameResult);
        }
    }

    private void branchResultBasedOnInput(String input, Players players, GameResult gameResult) {
        if (input.equals("all")) {
            printAllResult(players, gameResult);
            return;
        }
        printPlayerResult(input, players, gameResult);
    }

    private void printAllResult(Players players, GameResult gameResult) {
        String result = IntStream.range(0, players.size())
                .mapToObj(idx -> players.getName(idx) + " : " + gameResult.getResultName(idx))
                .collect(Collectors.joining("\n"));
        resultView.printGameResult(result);
    }

    private void printPlayerResult(String name, Players players, GameResult gameResult) {
        int playerIdx = players.findIndexByName(name)
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 플레이어는 존재하지 않습니다."));
        String result = gameResult.getResultName(playerIdx);
        resultView.printGameResult(result);
    }

}
