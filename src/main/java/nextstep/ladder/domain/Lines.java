package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private final int height;
    private final List<Line> lines = new ArrayList<>();

    public Lines(int height) {
        this.height = height;
    }

    public void add() {
        if (lines.isEmpty()) {
            lines.add(Line.of(height));
            return;
        }

        Line prev = lines.get(lines.size() - 1);
        lines.add(Line.of(prev));
    }

    public int size() {
        return lines.size();
    }

    public List<Line> getLines() {
        return lines;
    }
}
