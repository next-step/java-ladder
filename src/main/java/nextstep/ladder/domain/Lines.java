package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines drawLines(Participants participants, DrawStrategy drawStrategy) {
        List<Line> lines = new ArrayList<>();
        boolean previous = false;
        for (int i = 0; i < participants.countOfParticipants(); i++) {
            lines.add(new Line(drawStrategy.draw(i, previous)));
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
