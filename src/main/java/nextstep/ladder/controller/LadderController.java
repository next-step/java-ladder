package nextstep.ladder.controller;

import nextstep.ladder.model.LadderStatus;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Lines;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.Random;

public class LadderController {
    LadderStatus status;

    public LadderController(InputView view) {
        status = new LadderStatus(view.getNames(), view.getHeight());
    }

    public void generateLines(Random random) {
        status.forEach(line -> line.generateLine(random));
    }

    public void printLines(OutputView view) {
        view.printLadderStatus(status);
    }
}
