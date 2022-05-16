package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.service.LadderService;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public final class LadderController {
    private final LadderService ladderService;

    public LadderController(LadderService ladderService) {
        this.ladderService = ladderService;
    }

    public void run() {
        List<String> participantNames = InputView.insertParticipantNames();
        Ladder ladder = createLadder(gameParticipantCount(participantNames), InputView.ladderHeight());
        OutputView.executionResult();
        OutputView.printParticipantNames(participantNames);
        OutputView.printLadder(ladder);
    }

    public int gameParticipantCount(List<String> participantsNames) {
        return ladderService.gameParticipantCount(participantsNames);
    }

    public Ladder createLadder(int participant, int height) {
        return ladderService.createLadder(participant, height);
    }
}
