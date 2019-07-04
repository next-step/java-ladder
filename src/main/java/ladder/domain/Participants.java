package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants of(Names names) {
        List<Participant> participantList = names.getNames().stream()
                .map(Participant::new)
                .collect(Collectors.toList());
        return new Participants(participantList);
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public int size() {
        return participants.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participants that = (Participants) o;
        return Objects.equals(participants, that.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants);
    }
}
