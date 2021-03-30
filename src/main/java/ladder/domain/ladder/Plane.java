package ladder.domain.ladder;

import ladder.constants.Constants;
import ladder.domain.participant.ParticipantList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Plane {
    private final List<Line> lines;

    public Plane(ParticipantList participantList, Height ladder) {
        this.lines = IntStream.range(Constants.ZERO, ladder.height())
                .mapToObj(value -> new Line(participantList))
                .collect(Collectors.toList());
    }

    public List<Line> lines() {
        return this.lines;
    }

    protected int traverse(int index) {
        for (int count = Constants.ZERO; count < lines.size(); count++) {
            index = lines().get(count).movedIndex(index);
        }
        return index;
    }
}
