package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Lines {
    private List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(int width, int height) {
        List<Line> lines = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            lines.add(new Line(width));
        }

        return new Lines(lines);
    }

    public Stream<Line> stream() {
        return lines.stream();
    }
}
