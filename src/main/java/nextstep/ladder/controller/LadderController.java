package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.generator.ProductionGenerator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {

    private final ProductionGenerator productionGenerator;

    public LadderController(ProductionGenerator productionGenerator) {
        this.productionGenerator = productionGenerator;
    }

    public void createLadder() {
        String[] participantNames = InputView.inputParticipantNames();
        Participants participants = new Participants(participantNames);
        int height = InputView.inputLadderHeight();
        Ladder ladder = new Ladder(productionGenerator, height, participantNames.length);
        OutputView.printParticipants(participants.getValues());
        OutputView.printLadder(ladder.getLines());
    }
}
