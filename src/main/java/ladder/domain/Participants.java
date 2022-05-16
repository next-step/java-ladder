package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private static final String PARTICIPANT_DELIMITER = ",";

    private List<Participant> participants;

    private Participants(String participantsNames) {
        participants = Arrays.stream(participantsNames.split(PARTICIPANT_DELIMITER))
                .map(name -> Participant.from(name))
                .collect(Collectors.toList());
    }

    public static Participants from(String participantsNames) {
        return new Participants(participantsNames);
    }

    public int count() {
        return participants.size();
    }
}
