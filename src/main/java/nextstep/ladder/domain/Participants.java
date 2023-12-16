package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> players;
    private static final AtomicInteger sequence = new AtomicInteger(1);

    public Participants(String names) {
        this(Arrays.stream(names.split(","))
                .map(name -> Participant.nameOf(name, sequence.getAndIncrement())).collect(Collectors.toList()));
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
