package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    private Ladder(Participants participants, Height height) {
        lines = new ArrayList<>();
        for (int i = 0; i < height.value; i++) {
            lines.add(Line.from(participants));
        }
    }

    public static Ladder of(Participants participants, Height height) {
        return new Ladder(participants, height);
    }

    public void repeatAsHeight(LineRenderer lineRenderer) {
        lines.forEach(lineRenderer::render);
    }
}
