package controller;

import domain.Ladder;
import domain.LadderResult;
import domain.Line;
import domain.Players;
import strategy.PointsMakeStrategy;
import strategy.RandomPointsMakeStrategy;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Players players = inputView.inputPlayers();
        List<String> results = inputView.inputResults();

        int ladderHeight = inputView.inputLadderHeight();

        PointsMakeStrategy pointsMakeStrategy = new RandomPointsMakeStrategy();

        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            lines.add(Line.from(players.size(), pointsMakeStrategy));
        }
        Ladder ladder = Ladder.from(lines);

        OutputView outputView = new OutputView();
        outputView.printPlayers(players);
        outputView.printLadder(ladder);
        outputView.printResults(results);

        LadderResult ladderResult = ladder.play(players, results);

        inputView.printPlayerResult(ladderResult);

    }
}
