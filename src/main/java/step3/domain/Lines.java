package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private List<Line> lineList = new ArrayList<>();

    private Lines(List<Line> lineList) {
        this.lineList = lineList;
    }

    public static Lines of(List<Line> lines) {
        return new Lines(lines);
    }

    public List<Line> getLineList() {
        return lineList;
    }
}
