package step4.laddergame.controller;

import step4.laddergame.domain.ladder.*;
import step4.laddergame.domain.player.Players;

import java.util.List;

import static step4.laddergame.controller.LadderController.showResult;
import static step4.laddergame.ui.InputView.*;
import static step4.laddergame.ui.ResultView.*;

public class LadderGame {
    public static void main(String[] args) {
        List<String> names = inputNames();
        Players players = Players.of(names);
        Results results = Results.of(inputResults());
        Size size = Size.of(inputHeight(), names.size());
        Ladder ladder = Ladder.of(size, new LadderPointerRandomGenerator());
        LadderWinning winning = LadderWinning.of(players, results.match(ladder.moveAll()));

        printNames(players);
        printLadder(ladder);
        printResult(results);
        while (showResult(winning));

        close();
    }
}
