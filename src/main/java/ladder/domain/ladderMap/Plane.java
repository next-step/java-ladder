package ladder.domain.ladderMap;

import ladder.domain.Height;
import ladder.domain.ParticipantList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Plane {
    private final List<Line> lines;

    public Plane(ParticipantList participantList, Height ladder) {
        this.lines = IntStream.range(0, ladder.height())
                .mapToObj(value -> new Line(participantList))
                .collect(Collectors.toList());
    }

    public List<Line> lines() {
        return this.lines;
    }
}
