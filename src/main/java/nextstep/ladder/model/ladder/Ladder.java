package nextstep.ladder.model.ladder;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }

    public Position run(final Position startPosition) {
        return lines.stream()
                .reduce(startPosition, this::applyLineToPosition, (p1, p2) -> p2);
    }
    
    private Position applyLineToPosition(final Position position, final Line line) {
        return line.movePosition(position);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
} 
