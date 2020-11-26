package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Lines {
    private List<Line> lines;

    private Lines(final List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(final Length width, final Length height) {
        List<Line> lines = new ArrayList<>();
        for(int i = 0; i < height.getValue(); i++) {
            lines.add(Line.of(width));
        }

        return new Lines(lines);
    }

    public Stream<Line> stream() {
        return lines.stream();
    }
}
