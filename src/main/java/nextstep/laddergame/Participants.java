package nextstep.laddergame;

import java.util.Arrays;
import java.util.List;

public class Participants {

    private final List<Participant> participantList;

    public Participants(Participant... participantList) {
        this(Arrays.stream(participantList).toList());
    }

    public Participants(List<Participant> participantList) {
        this.participantList = participantList;
    }

}
