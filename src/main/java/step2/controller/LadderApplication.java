package step2.controller;

import step2.domain.Names;
import step2.view.InputView;

public class LadderApplication {
    private static final InputView inputView = new InputView();

    public static void main(String[] args) {
        final Names names = inputView.inputNames();
        System.out.println(names);
    }
}
