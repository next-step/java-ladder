package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderGame {

    public static void main(String[] args) {
        List<String> names = InputView.inputNames();

        Lines lines = new Lines(List.of(
                Line.from(List.of(new Point(false), new Point(false))),
                Line.from(List.of(new Point(false), new Point(false)))
        ));

        Ladder ladder = Ladder.of(names, lines, List.of());

        ResultView.printResultString();
        ResultView.printNames(names);
        ResultView.printLadder(ladder);
    }
}
