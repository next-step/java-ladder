package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private final Participants participants;
    private final List<Line> lineList;

    public LadderGame(Participants participants, int ladderHeight) {
        this(participants, generateLineList(participants, ladderHeight));
    }

    private LadderGame(Participants participants, List<Line> lineList) {
        this.participants = participants;
        this.lineList = lineList;
    }

    private static List<Line> generateLineList(Participants participants, int ladderHeight) {
        return IntStream.range(0, ladderHeight)
                .mapToObj(i -> new Line(participants.getCount()))
                .collect(Collectors.toList());
    }

    public Participants getParticipants() {
        return participants;
    }

    public List<Line> getLineList() {
        return lineList;
    }
}
