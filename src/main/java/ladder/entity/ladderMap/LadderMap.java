package ladder.entity.ladderMap;

import ladder.entity.participant.ParticipantList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderMap {

    private ParticipantList participantList;
    private List<Line> lines;

    public LadderMap(ParticipantList participantList, LadderHeight ladderHeight){
        this.participantList = participantList;
        this.lines = lines(participantList, ladderHeight);
    }

    private List<Line> lines(ParticipantList participantList, LadderHeight ladderHeight){
        return IntStream.range(0, ladderHeight.height())
                .mapToObj(count->new Line(participantList))
                .collect(Collectors.toList());
    }

    public ParticipantList participantList() {
        return participantList;
    }

    public List<Line> lines() {
        return lines;
    }
}
