package laddergame.domain;

import laddergame.validator.ParticipantValidator;
import laddergame.validator.ParticipantsValidator;
import laddergame.validator.Validatable;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Participants {
    private static final String PARTICIPANT_NAME_DELIMITER = ",";

    private Validatable<Set<Participant>> validator = new ParticipantsValidator();
    private final Set<Participant> participants;

    public Participants(String participants) {
        this(Stream.of(participants.split(PARTICIPANT_NAME_DELIMITER))
                .map(Participant::new)
                .collect(Collectors.toSet()));
    }

    private Participants(Set<Participant> participants) {
        validator.validate(participants);
        this.participants = participants;
    }

    public int size() {
        return participants.size();
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public String toResultString() {
        StringBuilder sb = new StringBuilder();

        participants.forEach(participant ->  {
            sb.append(participant.getResultName());
            sb.append(" ");
        });

        return sb.toString();
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
        StringBuilder sb = new StringBuilder("Participants{");
        sb.append("participants=").append(participants);
        sb.append('}');
        return sb.toString();
    }
}