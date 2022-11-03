package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines = new ArrayList<>();

    public Lines(int ladderHeight, int participantCount) {
        for(int i = 0; i < ladderHeight; i++){
            lines.add(new Line(participantCount));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
