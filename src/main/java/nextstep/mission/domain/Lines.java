package nextstep.mission.domain;

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

    public boolean checkHeight(int height) {
        return this.lines.size() == height;
    }

    public Line getLine(int position) {
        if (this.lines.size() < position + 1) {
            return null;
        }

        return this.lines.get(position);
    }
}
