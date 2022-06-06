package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder from(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("사다리 라인들이 존재하지 않습니다.");
        }
        return new Ladder(lines);
    }

    public static Ladder from(Line... lines) {
        return Ladder.from(List.of(lines));
    }

    public LadderResult play() {
        LadderResult result = new LadderResult();
        Line startLine = lines.get(0);
        for (int i = 0; i < startLine.countOfParticipants(); i++) {
            Position participant = Position.from(i);
            result.put(participant, goal(participant));
        }
        return result;
    }

    private Position goal(Position position) {
        Position goal = position;
        for (Line line : lines) {
            goal = line.movedFrom(goal);
        }
        return goal;
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }
}
