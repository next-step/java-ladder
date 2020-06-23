package nextstep.ladder.controller;

import nextstep.ladder.view.InputView;

public class Main {

    public static void main() {
        InputView inputView = new InputView();
        String[] userNames = inputView.inputUserNames();
        Integer ladderMaximumHeight = inputView.inputMaximumLadderHeight();


    }
}
