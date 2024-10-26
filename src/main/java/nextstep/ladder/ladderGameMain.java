package nextstep.ladder;

import nextstep.ladder.view.InputView;

public class ladderGameMain {
    private static final InputView inputView = new InputView();
    public static void main(String[] args) {
        inputView.receiveGamers();
        inputView.receiveMaxHeight();
    }
}
