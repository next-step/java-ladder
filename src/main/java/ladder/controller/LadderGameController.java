package ladder.controller;

import ladder.converter.ResultConverter;
import ladder.dto.LadderResultDto;
import ladder.model.ExecutionResults;
import ladder.model.Height;
import ladder.model.Ladder;
import ladder.model.Participants;
import ladder.model.RandomStrategy;
import ladder.validator.InputValidator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {

    private static final String ALL_PARTICIPANTS_COMMAND = "all";

    private final InputView inputView;

    private final OutputView outputView;

    public LadderGameController() {
        this(new InputView(), new OutputView());
    }

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        try {
            Participants participants = inputView.inputParticipants();
            ExecutionResults executionResults = inputView.inputExecutionResults();

            InputValidator.validate(participants, executionResults);

            Height height = inputView.inputLadderHeight();
            Ladder ladder = Ladder.of(participants.size(), height.getValue(), new RandomStrategy());

            initLadder(participants, executionResults, ladder);
            showParticipantResult(participants, executionResults, ladder);
        } catch (RuntimeException runtimeException) {
            outputView.printErrorMessage(runtimeException.getMessage());
        }

    }

    private void initLadder(Participants participants, ExecutionResults executionResults, Ladder ladder) {
        outputView.printLadder(participants, ladder, executionResults);
    }

    private void showParticipantResult(Participants participants, ExecutionResults executionResults, Ladder ladder) {
        LadderResultDto ladderResultDto
                = ResultConverter.convertIntoLadderResultDto(participants, executionResults, ladder);
        String participant = inputView.inputParticipantForResult();

        if (isAllParticipants(participant)) {
            outputView.printAllParticipantResults(ladderResultDto);
            return;
        }
        outputView.printParticipantResult(ladderResultDto, participant);
    }

    private boolean isAllParticipants(String participant) {
        return participant.equals(ALL_PARTICIPANTS_COMMAND);
    }

}
