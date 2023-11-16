package ladder.controller;

import ladder.view.InputView;

public class LadderController {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String names = inputView.names();
        System.out.println(names);
    }

}
