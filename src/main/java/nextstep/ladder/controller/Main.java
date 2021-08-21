package nextstep.ladder.controller;

import nextstep.ladder.model.CoordinateValue;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Names;
import nextstep.ladder.model.RandomLineDrawStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> nameStrings = InputView.readNames();
        Names names = new Names(nameStrings);
        CoordinateValue height = new CoordinateValue(InputView.readHeight());

        Ladder ladder = new Ladder(names, height, nameStrings.size());
        ladder.drawLines(new RandomLineDrawStrategy());

        OutputView.printLadder(ladder);
    }
}
