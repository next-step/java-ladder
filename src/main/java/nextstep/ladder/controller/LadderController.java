package nextstep.ladder.controller;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Results;
import nextstep.ladder.dto.ExecutionResultDto;
import nextstep.ladder.dto.LadderStandardDto;
import nextstep.ladder.dto.ResultsDto;
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

        LadderStandardDto ladderStandardDto = new LadderStandardDto(height, participantNames.length);

        Ladder ladder = new Ladder(productionGenerator, ladderStandardDto);

        OutputView.printLadderResult(participants.getValues(), ladder.getLines());
        OutputView.printResults(results.getValues());

        List<Integer> resultPosition = rideLadder(participants, ladder);
        ResultsDto resultsDto = new ResultsDto(resultPosition, results);
        ExecutionResultDto executionResultDto = new ExecutionResultDto(participants, resultsDto);

        rideLadderResult(executionResultDto);
    }

    private List<Integer> rideLadder(Participants participants, Ladder ladder) {
        List<Integer> ladderRideResult = new ArrayList<>();
        for (Participant participant : participants.getValues()) {
            int rideIndex = ladder.ride(participant.getIndex());
            ladderRideResult.add(rideIndex);
        }

        return ladderRideResult;
    }

    private void rideLadderResult(ExecutionResultDto executionResultDto) {
        boolean proceed = true;
        while (proceed) {
            String participant = InputView.inputParticipantResult();

            OutputView.printLadderRideResult(executionResultDto, participant);

            proceed = isGameOver(participant);
        }
    }

    private boolean isGameOver(String participant) {
        return !ALL_PARTICIPANT_RESULT.equals(participant);
    }
}
