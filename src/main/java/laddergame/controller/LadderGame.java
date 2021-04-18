package laddergame.controller;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.RandomLadderStrategy;
import laddergame.domain.ladder.Results;
import laddergame.domain.ladder.Size;
import laddergame.domain.player.Players;

import java.util.List;

import static laddergame.controller.LadderController.*;
import static laddergame.ui.InputView.*;
import static laddergame.ui.ResultView.*;

public class LadderGame {
    public static void main(String[] args) {
        List<String> names = inputNames();
        Players players = enroll(names);
        Results results = makeResults(inputResults());

        Size size = new Size(inputHeight(), names.size());
        Ladder ladder = makeLadder(size, new RandomLadderStrategy());
        setStatistics(ladder, results);

        printNames(players);
        printLadder(ladder);
        printResult(results);
        printWantResult(matchPlayer(players, inputWantName()));
        close();
    }
}
