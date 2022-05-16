package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.generator.PositionGenerator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {

    private final PositionGenerator productionGenerator;

    public LadderController(PositionGenerator productionGenerator) {
        this.productionGenerator = productionGenerator;
    }

    public void run() {
        String[] participantNames = InputView.inputParticipantNames();
        Participants participants = new Participants(participantNames);
        Height height = new Height(InputView.inputLadderHeight());

        Ladder ladder = new Ladder(productionGenerator, height.getValue(), participantNames.length);

        OutputView.printLadderResult(participants.getValues(), ladder.getLines());
    }
}
