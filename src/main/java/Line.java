import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<DotType> dots;

    public Line(List<DotType> dots) {
        this.dots = dots;
    }

    public Line(DotType... types) {
        this.dots = Arrays.stream(types).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;

        return this.dots.equals(line.dots);
    }

    public int size() {
        return this.dots.size();
    }

    public long nodeCount() {
        return this.dots.stream().filter(d -> d == DotType.NODE).count();
    }

    public boolean isBridge(int i) {
        return this.dots.get(i).is(DotType.BRIDGE);
    }
}
