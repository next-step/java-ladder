package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Participants;
import nextstep.ladder.service.LadderService;
import nextstep.ladder.view.InputTable;

import java.util.List;

public final class LadderController {
    private final LadderService ladderService;

    public LadderController(LadderService ladderService) {
        this.ladderService = ladderService;
    }

    public void run() {
        List<String> participantNames = InputTable.insertParticipantNames();
        Ladder ladder = createLadder(InputTable.ladderHeight(), gameParticipantCount(participantNames));
    }

    public int gameParticipantCount(List<String> participantsNames) {
        return ladderService.gameParticipantCount(participantsNames);
    }

    public Ladder createLadder(int height, int participant) {
        return ladderService.createLadder(height, participant);
    }
}
