package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {
    private List<Line> lines;

    public Lines(int height, int numberOfParticipants) {
        this.lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            this.lines.add(new Line(numberOfParticipants));
        }
    }

    public List<Line> value() {
        return Collections.unmodifiableList(lines);
    }
}
