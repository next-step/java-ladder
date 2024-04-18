package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.StreamSupport;

public class Game {
    private final Ladder ladder;
    private final Participants participants;
    private final Results results;

    public Game(Ladder ladder, Participants participants, Results results) {
        this.ladder = ladder;
        this.participants = participants;
        this.results = results;
    }

    public String getIndividualResult(Participant participant) {
        StreamSupport.stream(ladder.spliterator(), false)
                .forEach(line -> updatePosition(participant, line));
        return results.getResult(participant.getLocation());
    }

    public Map<String, String> getAllResult() {
        Map<String, String> result = new HashMap<>();

        StreamSupport.stream(participants.spliterator(), false)
                .forEach(participant -> result.put(participant.getName(), getIndividualResult(participant)));

        return result;
    }

    private void updatePosition(Participant participant, Line line) {
        Direction direction = line.getDirection(participant.getLocation());
        participant.updateLocation(direction);
    }
}
