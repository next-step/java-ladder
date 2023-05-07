package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private final List<Line> lines;


    public Lines(int ladderLength, int participantsCount) {
        final List<Line> lines = new ArrayList<>();

        for (int i = 0; i < ladderLength; i++) {
            lines.add(new Line(participantsCount));
        }

        this.lines = lines;
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
