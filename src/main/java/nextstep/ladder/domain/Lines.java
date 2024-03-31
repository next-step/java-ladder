package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lines implements LineFactory{

    private final List<Line> lines;
    private final int size;

    public Lines(LineFactory height, PointFactory pointFactory) {
        this(height.generateLines(pointFactory));
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
        this.size = lines.size();
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lines)) return false;
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public List<Line> generateLines(PointFactory pointFactory) {
        ArrayList<Line> lines = new ArrayList<>();
        for(int i =0; i < size; i++){
            lines.add(new Line(pointFactory));
        }
        return lines;
    }
}
