package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final ParticipantNames participantNames;
    private final List<Line> lines = new ArrayList<>();

    private Ladder(final ParticipantNames participantNames, final int height) {
        this.participantNames = participantNames;
        IntStream.range(0, height)
                .forEach(i -> lines.add(Line.from(participantCount())));
    }

    public static Ladder of(final ParticipantNames participantNames, final int height) {
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
