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

    public List<Line> value() {
        return Collections.unmodifiableList(lines);
    }

    public int height() {
        return this.lines.size();
    }

    public int numberOfParticipants() {
        return this.lines.get(0).numberOfParticipants();
    }
}
