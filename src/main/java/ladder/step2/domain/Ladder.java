package ladder.step2.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {
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
}
