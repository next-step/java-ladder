package nextstep.ladder.controller;

import nextstep.ladder.model.*;
import nextstep.ladder.view.LadderInputView;
import nextstep.ladder.view.LadderOutputView;

public class LadderApplication {
    private final LadderInputView ladderInputView;
    private final LadderOutputView ladderOutputView;

    public LadderApplication(LadderInputView ladderInputView, LadderOutputView ladderOutputView) {
        this.ladderInputView = ladderInputView;
        this.ladderOutputView = ladderOutputView;
    }

    public void run() {
        People people = ladderInputView.getPeople();
        Height height = ladderInputView.getHeight();

        LineGenerator lineGenerator = new LineGenerator(people, height);
        Lines lines = new Lines(lineGenerator.generateLines(), height);
        Ladder ladder = new Ladder(people, lines);

        ladderOutputView.getResult(ladder);
    }
}
