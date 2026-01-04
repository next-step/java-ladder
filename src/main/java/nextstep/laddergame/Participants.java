package nextstep.laddergame;

import java.util.Arrays;
import java.util.List;

public class Participants {

    private final List<Participant> participantList;

    public Participants(String participantList) {
        this(Arrays.stream(participantList.split(",")).map(String::trim).toArray(String[]::new));
    }

    public Participants(String... participantList) {
        this(Arrays.stream(participantList).map(Participant::new).toList());
    }

    public Participants(Participant... participantList) {
        this(Arrays.stream(participantList).toList());
    }

    public Participants(List<Participant> participantList) {
        this.participantList = participantList;
    }

    public List<Participant> getParticipantList() {
        return participantList;
    }
}
