package domain;

import java.util.AbstractMap;
import java.util.Map;

class PlayResult {

    private Position start;
    private Position end;

    PlayResult(Position start, Position end) {
        this.start = start;
        this.end = end;
    }

    Map.Entry<Participant, String> getEntry(Participants participants, Rewards rewards) {
        return new AbstractMap.SimpleEntry<>(
            participants.get(start.value()),
            rewards.get(end.value()));
    }
}
