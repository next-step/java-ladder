package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineList {
    private final List<Line> lineList = new ArrayList<>();

    public LineList() {
    }

    public void createLine(final int countOfPerson) {
        Line line = new Line(countOfPerson);
        line.createLine(false, 1);
        lineList.add(line);
    }

    public List<Line> getLineList() {
        return lineList;
    }
}
