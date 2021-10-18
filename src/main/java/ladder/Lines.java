package ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {

    private final List<Line> lines = new ArrayList<>();

    public Lines(int ladderHeight, int numberOfParticipant) {
        for (int i = 0 ; i < ladderHeight; i++) {
            Line line = new Line(numberOfParticipant);
            lines.add(line);
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getLineHeight() {
        return lines.size();
    }
}
