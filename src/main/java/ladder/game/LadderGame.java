package ladder.game;

import ladder.structure.Ladder;
import ladder.structure.connection.ConnectionStrategy;

import java.util.Collections;
import java.util.List;

public class LadderGame {
    private Ladder ladder;
    private Participants participants;
    private Results results;

    public LadderGame(String inputParticipant, int ladderHeight, ConnectionStrategy connectionStrategy, String inputResults) {
        this.participants = Participants.of(inputParticipant);
        this.ladder = new Ladder(this.participants.size(), ladderHeight, connectionStrategy);
        this.results = Results.of(inputResults, this.participants.size());
    }

    public LadderDTO getLadder() {
        return new LadderDTO(Collections.unmodifiableList(ladder.getConnectedLine()));
    }

    public boolean isConnected(int line, int width) {
        return ladder.isConnected(line, width);
    }

    public int getLadderHeight() {
        return ladder.getLadderHeight();
    }

    public int getLadderWidth() {
        return participants.size() - 1;
    }

    public List<String> getParticipants() {
        return Collections.unmodifiableList(participants.getNames());
    }

    public List<String> getResults() {
        return results.getResult();
    }
}
