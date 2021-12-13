package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final Participants participants;
    private final Ladder ladder;

    public LadderGame(Participants participants, int height) {
        this.participants = participants;
        this.ladder = Ladder.of(participants.size(), height);
    }

    public LadderGame(Participants participants, Ladder ladder) {
        this.participants = participants;
        this.ladder = ladder;
    }

    public String result(String name, LadderResult ladderResult) {
        int initialPosition = participants.initialPosition(name);

        return ladderResult.result(ladder.finalPoint(initialPosition));
    }

    public int height() {
        return ladder.height();
    }

    public List<Boolean> nextLine(int level) {
        return ladder.line(level);
    }

    public List<String> participantNames() {
        return participants.getNamesOfParticipants();
    }

    public List<String> allResults(LadderResult ladderResult) {
        List<String> results = new ArrayList<>();

        participantNames().forEach(name -> results.add(result(name, ladderResult)));

        return results;
    }
}
