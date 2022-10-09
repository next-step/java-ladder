package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {

    private final List<Line> lines;

    public Lines(int height, int numberOfParticipants) {
        this.lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            this.lines.add(new Line(numberOfParticipants));
        }
    }

    public String toLadderLines() {
        StringBuilder lines = new StringBuilder();
        for (Line line : this.lines) {
            lines.append(line.toLadderLine());
            lines.append("\n");
        }

        return lines.toString();
    }

    public List<Line> value() {
        return Collections.unmodifiableList(lines);
    }

    public Line getLine(int index) {
        return lines.get(index);
    }

    public int height() {
        return lines.size();
    }
}
