package nextstep.ladder.controller;

import nextstep.ladder.model.CoordinateValue;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Names;
import nextstep.ladder.model.RandomLineDrawStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Names names = new Names(InputView.readNames());
        CoordinateValue height = new CoordinateValue(InputView.readHeight());

        Ladder ladder = new Ladder(names, height);
        ladder.drawLines(new RandomLineDrawStrategy());

        OutputView.printLadder(ladder);
    }
}
