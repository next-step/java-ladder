package nextstep.ladder.model;

import java.util.Collections;
import java.util.List;

public class Lines {
    private List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public int doResult(int start) {
        int x = start;
        int y = 0;
        int height = lines.get(0).getPoints().size();

        while (y < height) {
            Line line = lines.get(start);
            Point point = line.getPoints().get(y);

            x = point.moveHorizontal(x);
            y++;
        }

        return x;
    }

    public List<Line> getLineList() {
        return Collections.unmodifiableList(lines);
    }
}
