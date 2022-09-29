package ladder.step2.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ladder {
    private static final String NEW_LINE = "\n";
    private static final int FIRST_PART_LINE_LENGTH = 4;
    
    private final List<Line> lines;
    
    public Ladder(List<Line> lines) {
        this.lines = lines;
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
        return lines.stream()
                .map(Line::toString)
                .map(line -> line.substring(FIRST_PART_LINE_LENGTH))
                .collect(Collectors.joining(NEW_LINE));
    }
}
