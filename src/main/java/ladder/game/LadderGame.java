package ladder.game;

import ladder.structure.Ladder;
import ladder.structure.connection.ConnectionStrategy;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {
    private Ladder ladder;
    private Participants participants;
    private Prizes prizes;

    public LadderGame(String inputParticipant, int ladderHeight, ConnectionStrategy connectionStrategy, String inputResults) {
        this.participants = Participants.of(inputParticipant);
        this.ladder = new Ladder(this.participants.size(), ladderHeight, connectionStrategy);
        this.prizes = Prizes.of(inputResults, this.participants.size());
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Participants getParticipants() {
        return participants;
    }

    public Prizes getPrizes() {
        return prizes;
    }

    public Map<String, String> getResult(String... users) {
        Map<String, String> result = new LinkedHashMap<>();
        for (String user : users) {
            int index = participants.indexOf(user);
            int finalPoint = ladder.getFinalPoint(index);
            result.put(user, prizes.getPrize(finalPoint));
        }
        return result;
    }

    public Map<String, String> getResultAll() {
        Map<String, String> result = new LinkedHashMap<>();
        for (String user : participants.getNames()) {
            int index = participants.indexOf(user);
            int finalPoint = ladder.getFinalPoint(index);
            result.put(user, prizes.getPrize(finalPoint));
        }
        return result;
    }
}
