package ladder.domain;

import java.util.Arrays;
import java.util.List;
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

    public List<Participant> getParticipants() {
        return List.copyOf(participants); // 방어적 복사
    }

    public int count() {
        return participants.size();
    }
}
