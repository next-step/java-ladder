package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineResults {
    private final List<Line> lineResults;

    public LineResults() {
        this(new ArrayList<>());
    }

    public LineResults(List<Line> lineResults) {
        this.lineResults = lineResults;
    }

    public void add(Line line) {
        lineResults.add(line);
    }

    public int arrivalPoint(int startLine, int startPoint) {
        int currentPoint = startPoint;
        for (int i = startLine; i < lineResults.size(); i++) {
            int movedPoint = lineResults.get(i).move(currentPoint);
            currentPoint = movedPoint;
        }
        return currentPoint;
    }
}
