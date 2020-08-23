package nextstep.mission;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private List<Participant> participants;
    private int height;
    private List<Line> lines;
    private int cursor;

    private Ladder(List<Participant> participants, int height) {
        this.participants = participants;
        this.height = height;
        this.lines = Stream.generate(() -> new Line(participants.size()))
                .limit(height)
                .collect(Collectors.toList());
        this.cursor = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return height == ladder.height &&
                Objects.equals(participants, ladder.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants, height);
    }

    public static Ladder make(List<Participant> participants, int height) {
        return new Ladder(participants, height);
    }

    public boolean hasNext() {
        return this.cursor < this.lines.size();
    }

    public Line getLine() {
        if (!hasNext())
            return null;

        return this.lines.get(this.cursor++);
    }
}
