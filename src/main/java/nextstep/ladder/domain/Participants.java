package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> participants;

    public Participants(String names) {
        this(Arrays.stream(names.split(","))
                .map(Participant::nameOf).collect(Collectors.toList()));
    }

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public int count() {
        return this.participants.size();
    }

    @Override
    public String toString() {
        return "Participants{" +
                "participants=" + participants +
                '}';
    }
}
