package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
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

    public void linesForEach(Runnable renderFirstPartOfLine, Consumer<Boolean> renderPoint, Runnable renderLadderStick, Runnable renderLastPartOfLine) {
        lines.forEach(line -> {
            renderFirstPartOfLine.run();
            line.pointsForEach(renderPoint, renderLadderStick);
            renderLastPartOfLine.run();
        });
    }
}
