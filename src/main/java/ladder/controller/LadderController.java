package ladder.controller;

import ladder.view.InputView;

import java.util.List;

public class LadderController {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        List<String> names = inputView.names();
    }

}
