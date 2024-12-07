import java.util.Arrays;
import java.util.List;

public class Line {
    private final int lineNumber;
    private final Dots dots;

    public Line(int lineNumber, DotType... types) {
        this(lineNumber, List.of(types));
    }

    public Line(int lineNumber, List<DotType> dotTypes) {
        this.lineNumber = lineNumber;
        this.dots = new Dots(lineNumber, dotTypes);
    }

    public int size() {
        return this.dots.size();
    }

    public boolean isBridge(int i) {
        return this.dots.isBridge(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;

        return this.lineNumber == line.lineNumber && this.dots.equals(line.dots);
    }

    @Override
    public String toString() {
        return this.dots.toString();
    }
}
