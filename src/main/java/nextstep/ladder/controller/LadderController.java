package nextstep.ladder.controller;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.lines.Lines;
import nextstep.ladder.domain.lines.RandomLinesFactory;

public class LadderController {

    private final RandomLinesFactory randomLinesFactory;

    public LadderController(RandomLinesFactory randomLinesFactory) {
        this.randomLinesFactory = randomLinesFactory;
    }

    public Ladder getLadder(List<String> names, int height) {
        Lines randomLines = randomLinesFactory.createLines(height, names.size());
        return new Ladder(names, randomLines);
    }

    public List<Participant> startGame(Ladder ladder, List<String> participantsNames, String target) {
        Participants participants = new Participants(participantsNames);
        return participants.createParticipants(target).startLadderGame(ladder);
    }
}
