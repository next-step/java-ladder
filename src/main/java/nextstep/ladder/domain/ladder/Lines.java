package nextstep.ladder.domain.ladder;

import java.util.List;

public class Lines {

    private final List<Line> lines;

    public Lines(Line... lines) {
        this(List.of(lines));
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public int size() {
        return this.lines.size();
    }

    public List<Line> getLines() {
        return lines;
    }

    public int move(int position) {
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }
}
