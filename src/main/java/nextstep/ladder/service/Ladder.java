package nextstep.ladder.service;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Participants;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(Participants participants, Height height) {
        this.lines = createLadder(participants, height);
    }

    public static Ladder valueOf(Participants participants, Height height) {
        return new Ladder(participants, height);
    }

    private List<Line> createLadder(Participants participants, Height height) {
        return Stream.generate(() -> Line.valueOf(participants))
                .limit(height.size())
                .collect(Collectors.toList());
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Ladder)) return false;
        final Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
