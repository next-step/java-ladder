package nextstep.ladder;

import nextstep.ladder.view.OutputView;

public class LadderGame {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        outputView.printLadder(new Ladder(5, 4));
    }

}
