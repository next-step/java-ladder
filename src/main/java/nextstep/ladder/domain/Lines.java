package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lines {

    private List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines drawLines(Participants participants, DrawStrategy drawStrategy) {
        List<Line> lines = new ArrayList<>();
        boolean previous = false;

        for (int i = 0; i < participants.countOfParticipants(); i++) {
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
