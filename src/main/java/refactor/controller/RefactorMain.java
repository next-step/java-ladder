package refactor.controller;

import ladder.util.InputUtil;
import refactor.domain.LadderGame;
import refactor.view.InputView;

public class RefactorMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.input();
    }
}
