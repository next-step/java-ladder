package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<LineType> points = new ArrayList<>();

    public Line(int personCount, NextPointRule nextPointRule) {

        points.add(LineType.FALSE);

        for (int i = 1; i < personCount; i++) {
            points.add(setNextPoint(prevPoint(i), nextPointRule));
        }
    }

    private LineType prevPoint(int index) {
        return points.get(index - 1);
    }

    private LineType setNextPoint(LineType lineType, NextPointRule nextPointRule) {
        if (lineType == LineType.TRUE) {
            return LineType.FALSE;
        }
        return LineType.of(nextPointRule.createNextPoint());
    }

    public List<String> getPoints() {
        return points.stream()
                .map(LineType::lineString)
                .collect(Collectors.toList());
    }

    public boolean hasLeftBar(int index) {
        return points.get(index) == LineType.TRUE;
    }

    public boolean hasRightBar(int index) {
        if (index + 1 >= points.size()) {
            return false;
        }
        return points.get(index + 1) == LineType.TRUE;
    }
}
