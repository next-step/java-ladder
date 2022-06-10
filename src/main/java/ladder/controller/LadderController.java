package ladder.controller;

import ladder.converter.ResultConverter;
import ladder.domain.*;
import ladder.dto.LadderResultDto;
import ladder.exception.InvalidInputSizeException;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private static final String ALL_PARTICIPANTS_COMMAND = "all";
    private final InputView inputView;
    private final OutputView outputView;

    private LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public LadderController() {
        this(new InputView(), new OutputView());
    }

    public void startLadderGame() {
        Participants participants = inputView.inputParticipants();
        ExecutionResults executionResults = inputView.inputExecutionResults();
        validateInputSize(participants, executionResults);

        Ladder ladder = initLadder(participants);
        printLadder(participants, executionResults, ladder);

        LadderResultDto ladderResultDto = ResultConverter.convertToResultDto(ladder, executionResults, participants);
        String participantForResult = inputView.inputParticipantForResult();
        printExecutionResult(ladderResultDto, participantForResult);
    }

    private void printLadder(Participants participants, ExecutionResults executionResults, Ladder ladder) {
        outputView.printLadder(ladder, participants, executionResults);
    }

    private void printExecutionResult(LadderResultDto ladderResultDto, String participantForResult) {
        if (participantForResult.equals(ALL_PARTICIPANTS_COMMAND)) {
            outputView.printAllParticipantResults(ladderResultDto);
            return;
        }
        outputView.printParticipantResult(ladderResultDto, participantForResult);
    }

    private Ladder initLadder(Participants participants) {
        int maxLadderHeight = inputView.inputMaxLadderHeight();
        LadderGenerator ladderGenerator = new LadderGenerator(new RandomDirectionGenerateStrategy());
        return ladderGenerator.createLadder(participants.size(), maxLadderHeight);
    }

    private void validateInputSize(Participants participants, ExecutionResults executionResults) {
        if (participants.size() != executionResults.size()) {
            throw new InvalidInputSizeException(participants.size(), executionResults.size());
        }
    }
}
