package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class WidthGenerator {
    private List<Point> widthLines;

    public WidthGenerator(int userCounts) {
        this.widthLines = generate(userCounts);
    }

    public WidthGenerator(List<Point> widthLines) {
        this.widthLines = new ArrayList<>(widthLines);
    }

    public List<Point> getWidthLines() {
        return widthLines;
    }

    public List<Point> generate(int personCount) {
        List<Point> lines = new ArrayList<>();
        for (int line = 0, maxLine = personCount - 1; line < maxLine; line++) {
            lines.add(new Point(Math.round(Math.random()) < 0.5));
        }
        return lines;
    }
}
