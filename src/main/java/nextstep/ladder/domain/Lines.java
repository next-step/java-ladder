package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(Height height, Names names) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(Line.of(names.getLadderNames().size()));
        }

        return new Lines(lines);
    }

    public List<Line> getLines() {
        return lines;
    }
}
