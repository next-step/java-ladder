package laddergame.domain;

import laddergame.validator.Validatable;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Participants implements Validatable<Set<Participant>> {
    private static final String PARTICIPANT_NAME_DELIMITER = ",";

    private final Set<Participant> participants;

    public Participants(String participants) {
        this(Stream.of(participants.split(PARTICIPANT_NAME_DELIMITER))
                .map(Participant::new)
                .collect(Collectors.toSet()));
    }

    public Participants(Set<Participant> participants) {
        validate(participants);
        this.participants = participants;
    }

    public int size() {
        return participants.size();
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public String toResultString() {
        final StringBuilder sb = new StringBuilder();

        participants.stream()
                .forEach(participant ->  {
                    sb.append(participant.toResultString());
                    sb.append(" ");
                });

        return sb.toString();
    }

    @Override
    public boolean isValid(Set<Participant> target) {
        return target != null && target.size() >= 2;
    }

    @Override
    public String getInvalidMessage() {
        return "참가자는 2인 이상이어야 합니다.";
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Participants{");
        sb.append("participants=").append(participants);
        sb.append('}');
        return sb.toString();
    }
}