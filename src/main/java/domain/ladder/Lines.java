package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lines {
    private List<LadderLine> lines;

    public Lines(List<LadderLine> lines) {
        this.lines = new ArrayList<>();
        for(LadderLine line : lines){
            this.lines.add(line);
        }
    }

    public List<LadderLine> getLine() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lines lines = (Lines) o;
        return Objects.equals(lines, lines.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public String toString() {
        return "Lines{" +
                "lines=" + lines +
                '}';
    }
}
