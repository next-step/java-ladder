package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private List<Line> lineList;

    public Lines() {
        lineList = new ArrayList<>();
    }

    public Lines(List<Line> lineList) {
        this.lineList = lineList;
    }

    public void addLine(Line line) {
        lineList.add(line);
    }
}
