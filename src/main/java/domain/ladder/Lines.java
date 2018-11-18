package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lines {
    private List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = new ArrayList<>();
        for(Line line : lines){
            this.lines.add(line);
        }
    }

    public List<Line> getLine() {
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

}
