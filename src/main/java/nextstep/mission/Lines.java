package nextstep.mission;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {

    private List<Line> lines;

    public Lines(int size, int height) {
        this.lines = Stream.generate(() -> new Line(size))
                .limit(height)
                .collect(Collectors.toList());
    }

    public int getHeight() {
        return this.lines.size();
    }

    public Line getLine(int position) {
        return this.lines.get(position);
    }
}
