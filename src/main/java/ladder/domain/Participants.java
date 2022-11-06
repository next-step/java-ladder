package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Participants {

    private final List<Participant> participants;

    public Participants(final List<Participant> participants) {
        validateOrThrow(participants);

        this.participants = participants;
    }

    public Participants(final Participants participants) {
        this(participants.getParticipants()
                         .stream()
                         .map(Participant::new)
                         .collect(Collectors.toList()));
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }

    public int size() {
        return this.participants.size();
    }

    private void validateOrThrow(final List<Participant> participants) {
        if (Objects.isNull(participants) || participants.size() == 0) {
            throw new IllegalArgumentException("참가자는 최소 1명 이상이여야 합니다.");
        }
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
