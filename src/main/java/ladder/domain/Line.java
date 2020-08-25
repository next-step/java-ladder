package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final Random RANDOM_INSTANCE = new Random();

    private final List<LineType> points = new ArrayList<>();
    private final int personCount;

    public Line(int personCount) {
        this.personCount = personCount;
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

    public void printRow() {
        points.forEach(lineType -> System.out.print(lineType.printLine()));
        System.out.println();
    }
}
