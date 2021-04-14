package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.strategy.RandomDirectionStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderController {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        Players players = new Players(inputView.players());
        Prizes prizes = new Prizes(players.countOfPlayer(), inputView.prizes());
        LadderHeight ladderHeight = new LadderHeight(inputView.height());

        AllPointsForLines allPointsForLines = new AllPointsForLines(new RandomDirectionStrategy());
        List<Points> allPoints = allPointsForLines.allPoints(players.countOfPlayer(), ladderHeight);
        Lines lines = Lines.from(allPoints);
        Ladder ladder = new Ladder(lines);
        printLadderResult(players, prizes, ladder);

        MatchedResult matchedResult = ladder.map(players.names(), prizes.names());
        printResultOfTarget(matchedResult, inputView.targetPlayer());
    }

    private void printLadderResult(Players players, Prizes prizes, Ladder ladder) {
        resultView.printResultPhrase();
        resultView.printNames(players.names());
        resultView.printLadder(ladder.linesConnection());
        resultView.printNames(prizes.names());
    }

    private void printResultOfTarget(MatchedResult matchedResult, String targetPlayerName) {
        if (matchedResult.isAll(targetPlayerName)) {
            resultView.printAllResult(matchedResult.all());
        }

        if (!matchedResult.isAll(targetPlayerName) && matchedResult.containsKey(targetPlayerName)) {
            resultView.printResultOfTarget(matchedResult.get(targetPlayerName));
        }
    }
}
