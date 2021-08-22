package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lineList = new ArrayList<>();

    public void addLine(Line line) {
        lineList.add(line);
    }

    public List<Line> getLineList() {
        return this.lineList;
    }
}
