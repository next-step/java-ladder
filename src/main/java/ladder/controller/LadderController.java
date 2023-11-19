package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Names;
import ladder.factory.PointFactory;
import ladder.view.InputView;

public class LadderController {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        Names names = new Names(inputView.names());
        int ladderHeight = inputView.ladderHeight();
        Ladder ladder = new Ladder(ladderHeight, names.size(), new PointFactory());
    }

}
