package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Lines;
import nextstep.ladder.model.LinesGenerator;
import nextstep.ladder.model.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {

    private final LinesGenerator linesGenerator = new LinesGenerator();

    public void game() {
        Participants participants = new Participants(InputView.inputGameParticipants());
        int height = InputView.inputLadderHeight();
        Lines lines = new Lines(linesGenerator.generatorLines(participants.getNumbersOfParticipants(), height));

        Ladder ladder = new Ladder(participants, lines, height);
        OutputView.printLadder(ladder);
    }
}
