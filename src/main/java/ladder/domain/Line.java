package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final NextPointRule nextPointRule;

    private final List<LineType> points = new ArrayList<>();

    public Line(int personCount, NextPointRule nextPointRule) {

        points.add(LineType.FALSE);
        this.nextPointRule = nextPointRule;

        for (int i = 1; i < personCount; i++) {
            points.add(nextPoint(points.get(i - 1)));
        }
    }

    private LineType nextPoint(LineType lineType) {
        if (lineType == LineType.TRUE) {
            return LineType.FALSE;
        }
        return LineType.of(nextPointRule.createNextPoint());
    }

    public List<String> getLineList() {
        return points.stream()
                .map(LineType::lineString)
                .collect(Collectors.toList());
    }
}
