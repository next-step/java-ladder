package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Lines {
    private List<Line> lines = new ArrayList<>();

    public void add(Line line) {
        lines.add(line);
    }

    public int size() {
        return lines.size();
    }

    public Stream<Line> stream() {
        return lines.stream();
    }
}
