package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> players;

    public Participants(String names) {
        this(Arrays.stream(names.split(","))
                .map(Participant::nameOf).collect(Collectors.toList()));
    }

    public Participants(List<Participant> players) {
        this.players = players;
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(players);
    }

    public int count() {
        return this.players.size();
    }

    @Override
    public String toString() {
        return "Participants{" +
                "players=" + players +
                '}';
    }
}
