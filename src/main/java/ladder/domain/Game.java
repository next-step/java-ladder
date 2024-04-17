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

    public String getIndividualResult(String participant) {
        CurrentLocation currentLocation = participants.getParticipantStartLocation(participant);
        StreamSupport.stream(ladder.spliterator(), false)
                .forEach(line -> updatePosition(currentLocation, line));
        return results.getResult(currentLocation.getLocation());
    }

    public Map<String, String> getAllResult() {
        Map<String, String> result = new HashMap<>();

        StreamSupport.stream(participants.spliterator(), false)
                .forEach(participant -> result.put(participant, getIndividualResult(participant)));

        return result;
    }

    private void updatePosition(CurrentLocation location, Line line) {
        Direction direction = line.getDirection(location.getLocation());
        location.updateLocation(direction);
    }
}
