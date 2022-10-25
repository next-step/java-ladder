package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Names;
import ladder.view.InputView;
import ladder.view.ResultView;

import static ladder.domain.Names.createNames;

public class LadderController {
    private final Names names;
    private final Ladder ladder;

    public LadderController() {
        this.names = null;
        this.ladder = null;
    }

    public LadderController(String names, int height) {
        this.names = createNames(names);
        this.ladder = createLadder(this.names.getCountOfNames(), height);
    }

    public Ladder createLadder(int countOfNames, int height) {
        return new Ladder(countOfNames, height);
    }

    public Names getNames() {
        return names;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public void start() {
        String candidateNames = InputView.inputCandidateNames();
        Integer maxHeight = InputView.inputMaxLadderHeight();
        LadderController controller = new LadderController(candidateNames, maxHeight);

        ResultView.printResult(controller.getNames(), controller.getLadder());
    }
}
