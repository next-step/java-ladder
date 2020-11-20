package nextstep.ladder.domain;

import nextstep.ladder.LineRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(Participants participants, Height height) {
        lines = new ArrayList<>(height.value);

        IntStream.range(0, height.value)
                .forEach(index -> lines.add(Line.from(participants)));
    }

    public static Ladder of(Participants participants, Height height) {
        return new Ladder(participants, height);
    }

    public void repeatAsHeight(LineRenderer lineRenderer) {
        lines.forEach(lineRenderer::render);
    }
}
