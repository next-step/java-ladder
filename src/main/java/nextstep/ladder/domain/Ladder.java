package nextstep.ladder.domain;

import nextstep.ladder.generator.LineGenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(Line... lines) {
        this.lines = Arrays.asList(lines);
    }

    public static Ladder valueOf(Participants participants, Height height) {
        Line[] ladder = createLadder(participants, height);
        return new Ladder(ladder);
    }

    private static Line[] createLadder(Participants participants, Height height) {
        return Stream.generate(() -> Line.valueOf(participants))
                .limit(height.size())
                .toArray(Line[]::new);
    }

    public static Ladder valueOf(Participants participants, Height height, LineGenerator generator) {
        Line[] ladder = createLadder(participants, height, generator);
        return new Ladder(ladder);
    }

    private static Line[] createLadder(Participants participants, Height height, LineGenerator generator) {
        return Stream.generate(() -> Line.valueOf(participants, generator))
                .limit(height.size())
                .toArray(Line[]::new);
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

    @Override
    public String toString() {
        return String.valueOf(lines);
    }
}
