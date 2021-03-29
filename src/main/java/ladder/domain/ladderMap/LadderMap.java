package ladder.domain.ladderMap;

import ladder.domain.Height;
import ladder.domain.participant.ParticipantList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderMap {

    private ParticipantList participantList;
    private Plane plane;

    public LadderMap(ParticipantList participantList, Height ladder) {
        this.participantList = participantList;
        this.plane = new Plane(participantList, ladder);
    }

    public ParticipantList participantList() {
        return this.participantList;
    }

    public Plane plane() {
        return this.plane;
    }

    public List<Integer> traverse() {
        return IntStream.range(0, participantList().size())
                .mapToObj(plane::traverse)
                .collect(Collectors.toList());
    }
}
