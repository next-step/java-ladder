package nextstep.ladder.controller;

import java.util.HashMap;
import java.util.Map;
import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Results;
import nextstep.ladder.generator.PositionGenerator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {
    private static final String ALL_PARTICIPANT_RESULT = "all";

    private final PositionGenerator productionGenerator;

    public LadderController(PositionGenerator productionGenerator) {
        this.productionGenerator = productionGenerator;
    }

    public void run() {
        String[] participantNames = InputView.inputParticipantNames();
        Participants participants = new Participants(participantNames);
        String[] executionResults = InputView.inputExecutionResults();
        Results results = new Results(executionResults);
        Height height = new Height(InputView.inputLadderHeight());

        Ladder ladder = new Ladder(productionGenerator, height.getValue(), participantNames.length);

        OutputView.printLadderResult(participants.getValues(), ladder.getLines());
        OutputView.printResults(results.getValues());

        rideLadder(participants, ladder, results);
    }

    private void rideLadder(Participants participants, Ladder ladder, Results results) {
        Map<String, String> executionResult = new HashMap<>();
        for (Participant participant : participants.getValues()) {
            int rideIndex = ladder.ride(participant.getIndex());
            String rideResult = results.getValues().get(rideIndex);
            executionResult.put(participant.toString(), rideResult);
        }

        boolean proceed = true;
        while (proceed) {
            String participant = InputView.inputParticipantResult();

            OutputView.printLadderRideResult(executionResult, participant);

            proceed = isGameOver(participant);
        }
    }

    private boolean isGameOver(String participant) {
        return !ALL_PARTICIPANT_RESULT.equals(participant);
    }
}
