package step2.controller;

import step2.dto.Height;
import step2.domain.Ladder;
import step2.dto.Players;
import step2.view.InputView;
import step2.view.OutputView;

public class LadderApplication {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        final Players players = inputView.inputNames();
        final Height height = inputView.inputHeight();

        final Ladder ladder = new Ladder(players, height.height());
        outputView.printLadder(ladder.print());
        outputView.printLadder(ladder.toString());
    }
}
