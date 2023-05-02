package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private static final int SECOND_INDEX = 1;

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines init(Participants participants, DrawStrategy drawStrategy) {
        List<Line> lines = new ArrayList<>();

        boolean previous = drawFirstIndex(lines);

        for (int i = SECOND_INDEX; i < participants.getNumberOfNames(); i++) {
            previous = drawStrategy.draw(previous);
            lines.add(new Line(previous));
        }

        return new Lines(lines);
    }

    private static boolean drawFirstIndex(List<Line> lines) {
        FirstDrawStrategy firstStrategy = new FirstDrawStrategy();
        boolean previous = firstStrategy.draw(false);

        lines.add(new Line(previous));
        return previous;
    }

    public Line getCurrentLine(int index) {
        return lines.get(index);
    }

    public int getNumberOfLines() {
        return lines.size();
    }

}
