package nextstep.step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final ParticipantNames participantNames;
    private final List<Line> lines;

    private Ladder(final ParticipantNames participantNames, final Height height) {
        this.participantNames = participantNames;
        lines = IntStream.range(0, height.value())
                .mapToObj(i -> Line.from(participantCount()))
                .collect(Collectors.toList());
    }

    public static Ladder of(final ParticipantNames participantNames, final Height height) {
        return new Ladder(participantNames, height);
    }

    public ParticipantNames getParticipantNames() {
        return participantNames;
    }

    public List<Line> getLines() {
        return lines;
    }

    private int participantCount() {
        return participantNames.count();
    }
}
