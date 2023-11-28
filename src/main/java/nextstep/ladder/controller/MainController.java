package nextstep.ladder.controller;

import nextstep.ladder.view.InputView;

public class MainController {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String names = inputView.inputUserNames();

    }

}
