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
        Height height = new Height(inputView.height());
        AllPointsForLines allPointsForLines = new AllPointsForLines(new RandomDirectionStrategy());
        List<Points> allPoints = allPointsForLines.allPoints(players.countOfPlayer(), height);
        Lines lines = Lines.from(allPoints);
        Ladder ladder = new Ladder(lines);
        resultView.printResultPhrase();
        resultView.printNames(players.names());
        resultView.printLadder(ladder.linesConnection());
        resultView.printNames(prizes.names());
    }
}
