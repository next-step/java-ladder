package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private static final int FIRST_INDEX = 0;

    private List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines drawLines(LadderInputs participants, DrawStrategy drawStrategy) {
        List<Line> lines = new ArrayList<>();
        boolean previous = false;

        for (int i = FIRST_INDEX; i < participants.countOfInputs(); i++) {
            boolean draw = drawStrategy.draw(i, previous);
            lines.add(new Line(draw));
            previous = draw;
        }

        return new Lines(lines);
    }

    public int numberOfLines() {
        return lines.size();
    }

    public List<Line> getLines() {
        return lines;
    }
}
