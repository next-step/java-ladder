package laddergame.controller;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.RandomLadderStrategy;
import laddergame.domain.ladder.Size;
import laddergame.domain.player.Players;

import java.util.List;

import static laddergame.controller.LadderFactory.*;
import static laddergame.ui.InputView.inputHeight;
import static laddergame.ui.InputView.inputNames;
import static laddergame.ui.ResultView.printLadder;
import static laddergame.ui.ResultView.printNames;

public class LadderGame {
    public static void main(String[] args) {
        List<String> names = inputNames();
        Players players = enroll(names);

        Size size = new Size(inputHeight(), names.size());
        Ladder ladder = makeLadder(size);
        ladder.makeLink(new RandomLadderStrategy());

        printNames(players);
        printLadder(ladder);
    }
}
