package nextstep.ladder.controller;

import nextstep.ladder.domain.executionresult.ExecutionResult;
import nextstep.ladder.domain.executionresult.ExecutionResults;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Stage;
import nextstep.ladder.domain.ladder.factory.StageFactory;
import nextstep.ladder.domain.ladder.line.strategy.HorizontalLinesGenerateRandomStrategy;
import nextstep.ladder.domain.participant.Participant;
import nextstep.ladder.domain.participant.Participants;
import nextstep.ladder.view.input.InputView;
import nextstep.ladder.view.output.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final InputView inputView;
    private final OutputView outputView;

    public Game(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Participants participants = getParticipants();
        ExecutionResults executionResults = getExecutionResult();
        Stage stage = getStage(participants);
        List<Ladder> ladders = stage.getLadders();

        outputView.printParticipants(participants);
        outputView.printLadders(ladders);
        outputView.printExecutionResults(executionResults);

    }

    private ExecutionResults getExecutionResult() {
        List<ExecutionResult> executionResults = inputView.receiveExecutionResult().stream()
                .map(ExecutionResult::new)
                .collect(Collectors.toList());
        return new ExecutionResults(executionResults);
    }

    private Stage getStage(Participants participants) {
        int height = inputView.receiveLadderHeight();
        return StageFactory.generateWith(height, participants,
                new HorizontalLinesGenerateRandomStrategy());
    }

    private Participants getParticipants() {
        List<String> userNames = inputView.receiveUserNames();

        return new Participants(userNames.stream()
                .map(Participant::new)
                .collect(Collectors.toList()));
    }
}
