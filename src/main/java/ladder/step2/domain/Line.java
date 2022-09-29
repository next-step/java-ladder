package ladder.step2.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {
    private final List<PartLine> partLines;
    
    public Line(List<PartLine> partLines) {
        this.partLines = partLines;
    }
    
    @Override
    public String toString() {
        return partLines.stream()
                .map(PartLine::toString)
                .collect(Collectors.joining());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(partLines, line.partLines);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(partLines);
    }
}
