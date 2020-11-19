package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(NumberOfParticipants numberOfParticipants, Height height) {
        lines = new ArrayList<>();
        for (int i = 0; i < height.value; i++) {
            lines.add(new Line(numberOfParticipants));
        }
    }
}
