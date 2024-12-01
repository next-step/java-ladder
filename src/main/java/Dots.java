import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dots {
    private final List<Dot> values;

    public Dots(int lineNumber, List<DotType> types) {
        this.values = new ArrayList<>();

        for (int i = 0; i < types.size(); i++) {
            Point p = PointCache.get(lineNumber, i);
            Dot dot = new Dot(p, types.get(i));

            DotCache.put(p, dot);

            this.values.add(dot);
        }
    }

    public int size() {
        return this.values.size();
    }

    public boolean isBridge(int i) {
        return this.values.get(i).isBridge();
    }

    @Override
    public String toString() {
        return this.values.stream()
                .map(Dot::print)
                .collect(Collectors.joining(""));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dots dots = (Dots) o;

        return this.values.equals(dots.values);
    }
}
