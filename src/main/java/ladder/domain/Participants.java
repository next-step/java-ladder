package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Participants {
    private static final String PARTICIPANT_DELIMITER = ",";

    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants from(String participantsNames) {
        List<Participant> participants = Arrays.stream(participantsNames.split(PARTICIPANT_DELIMITER))
                .map(Participant::from)
                .collect(Collectors.toList());
        return new Participants(participants);
    }

    public int count() {
        return participants.size();
    }

    public Position positionOf(Participant participant) {
        int index = participants.indexOf(participant);
        if (index < 0) {
            throw new IllegalArgumentException("해당하는 참여자가 존재하지 않습니다.");
        }

        return Position.from(index);
    }

    public List<Participant> getParticipants() {
        return List.copyOf(participants);
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
