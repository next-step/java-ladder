package nextstep.ladder.controller;

import nextstep.ladder.Ladder;
import nextstep.ladder.LadderFactory;
import nextstep.ladder.participant.Participant;
import nextstep.ladder.participant.Participants;
import nextstep.ladder.result.ExecutionResult;
import nextstep.ladder.view.input.InputView;
import nextstep.ladder.view.output.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Participants participants = getParticipants();

        List<String> executionResult = inputView.receiveExecutionResult();

        Ladder ladder = getLadder(participants);
        outputView.printLadder(participants, ladder, executionResult);

        ExecutionResult result = ladder.startGame();

        String target = inputView.receiveTarget();
        outputView.printTargetResult(target, participants, executionResult, result);
    }

    private Ladder getLadder(Participants participants) {
        int height = inputView.receiveLadderHeight();
        Ladder ladder = LadderFactory.generate(height, participants.size());
        return ladder;
    }

    private Participants getParticipants() {
        List<String> userNames = inputView.receiveUserNames();
        List<Participant> participants = userNames.stream()
                .map(Participant::new)
                .collect(Collectors.toList());
        return new Participants(participants);
    }
}
