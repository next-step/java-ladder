package step2.controller;

import step2.dto.Height;
import step2.domain.LadderGame;
import step2.dto.Names;
import step2.view.InputView;

public class LadderApplication {
    private static final InputView inputView = new InputView();

    public static void main(String[] args) {
        final Names names = inputView.inputNames();
        System.out.println(names);
        final Height height = inputView.inputHeight();
        System.out.println(height);

        final LadderGame ladderGame = new LadderGame(names.names(), height.height());
        System.out.println(ladderGame);
    }
}
