package nextstep.ladder.service;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Position;
import nextstep.ladder.generator.LineGenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(final Line... lines) {
        this.lines = Arrays.asList(lines);
    }

    public static Ladder valueOf(final Line... lines) {
        return new Ladder(lines);
    }

    public static Ladder valueOf(
            final Participants participants, final Height height, final LineGenerator generator) {
        Line[] lines = Stream.generate(() -> generator.createLine(participants.size()))
                .limit(height.size())
                .toArray(Line[]::new);
        return Ladder.valueOf(lines);
    }

    public Position findEndPosition(Position movePosition) {
        for(Line line : lines) {
            movePosition = line.move(movePosition);
        }
        return movePosition;
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
