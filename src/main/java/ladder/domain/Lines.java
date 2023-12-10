package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {
    private List<Line> lineList = new ArrayList<>();
    private int limitCount;

    public Lines(int limitCount) {
        this.limitCount = limitCount;
    }

    public void addLine(Line line) {
        this.lineList.add(line);
    }

    public final List<Line> getLines() {
        return Collections.unmodifiableList(lineList);
    }
}
