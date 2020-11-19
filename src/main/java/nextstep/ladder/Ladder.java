package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    private Ladder(NumberOfParticipants numberOfParticipants, Height height) {
        lines = new ArrayList<>();
        for (int i = 0; i < height.value; i++) {
            lines.add(Line.from(numberOfParticipants));
        }
    }

    public static Ladder of(NumberOfParticipants numberOfParticipants, Height height) {
        return new Ladder(numberOfParticipants, height);
    }

    public void repeatAsHeight(LineRenderer lineRenderer) {
        lines.forEach(lineRenderer::render);
    }
}
