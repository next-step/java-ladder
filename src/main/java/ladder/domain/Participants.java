package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    protected static final String PARTICIPANT_SEPARATOR = ",";

    private final List<Participant> participants;

    public Participants(String participantChunk) {
        this(of(participantChunk));
    }

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    private static List<Participant> of(String participantChunk) {
        return Arrays.stream(participantChunk.split(PARTICIPANT_SEPARATOR))
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public int countOfPerson() {
        return this.participants.size();
    }
}
