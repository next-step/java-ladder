package ladder.backEnd.controller;

import ladder.backEnd.domain.Ladder;
import ladder.backEnd.domain.Lines;
import ladder.frontEnd.InputView;
import ladder.frontEnd.ResultView;

import java.util.List;

public class LadderController {

    private static final InputView INPUT_VIEW = new InputView();
    private static final ResultView RESULT_VIEW = new ResultView();

    public void start() {
        List<String> names = INPUT_VIEW.askEnterNames();
        int height = INPUT_VIEW.askEnterLadderHeight();

        Ladder ladder = new Ladder();
        Lines lines = ladder.create(names, height);

        RESULT_VIEW.printLadder(names, lines);


    }
}
