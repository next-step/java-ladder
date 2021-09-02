package nextstep.ladder.controller;

import nextstep.ladder.domain.executionresult.ExecutionResult;
import nextstep.ladder.domain.ladder.Ladders;
import nextstep.ladder.domain.ladder.factory.LaddersFactory;
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

        ExecutionResult executionResult = getExecutionResult();

        int ladderCount = participants.size();
        Ladders ladders = getLadders(ladderCount);

        outputView.printParticipants(participants);
        outputView.printLadders(ladders);
        outputView.printExecutionResult(executionResult);
    }

    private ExecutionResults getExecutionResult() {
        List<ExecutionResult> executionResults = inputView.receiveExecutionResult().stream()
                .map(ExecutionResult::new)
                .collect(Collectors.toList());
        return new ExecutionResults(executionResults);
    }

    private Ladders getLadders(int ladderCount) {
        int height = inputView.receiveLadderHeight();
        return LaddersFactory.generateWith(height, ladderCount,
                new HorizontalLinesGenerateRandomStrategy());
    }

    private Participants getParticipants() {
        List<String> userNames = inputView.receiveUserNames();

        return new Participants(userNames.stream()
                .map(Participant::new)
                .collect(Collectors.toList()));
    }
}
