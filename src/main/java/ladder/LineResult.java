package ladder;

import java.util.ArrayList;
import java.util.List;

public class LineResult {
    private final List<PointResult> pointResults;

    public LineResult() {
        pointResults = new ArrayList<>();
    }

    public void add(PointResult pointResult) {
        this.pointResults.add(pointResult);
    }

    public List<PointResult> getPointResults() {
        return pointResults;
    }

    @Override
    public String toString() {
        return "LineResult{" +
                "pointResults=" + pointResults +
                '}';
    }
}
