package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Line {

    private final Random RANDOM_INSTANCE = new Random();

    private final List<LineType> points = new ArrayList<>();

    public Line(int personCount) {
        points.add(LineType.FALSE);

        for (int i = 1; i < personCount; i++) {
            points.add(nextPoint(points.get(i - 1)));
        }
    }

    private LineType nextPoint(LineType lineType) {
        if (lineType == LineType.TRUE) {
            return LineType.FALSE;
        }
        return LineType.of(RANDOM_INSTANCE.nextBoolean());
    }

    public List<String> getLineList() {
        return points.stream()
                .map(LineType::lineString)
                .collect(Collectors.toList());
    }
}
