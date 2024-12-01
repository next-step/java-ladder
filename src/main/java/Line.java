import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final int lineNumber;
    private final List<Dot> dots;

    public Line(int lineNumber, List<DotType> dotTypes) {
        this.lineNumber = lineNumber;

        this.dots = new ArrayList<>();

        for(int i = 0; i < dotTypes.size(); i++) {
            Point p = PointCache.get(lineNumber, i);
            Dot dot = new Dot(p, dotTypes.get(i));

            DotCache.put(p, dot);
            this.dots.add(dot);
        }
    }

    public Line(int lineNumber, DotType... types) {
        this(lineNumber, Arrays.asList(types));
    }

    public int size() {
        return this.dots.size();
    }

    public long nodeCount() {
        return this.dots.stream().filter(Dot::isNode).count();
    }

    public boolean isBridge(int i) {
        return this.dots.get(i).isBridge();
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
        return this.dots.stream()
                .map(Dot::print)
                .collect(Collectors.joining(""));
    }
}
