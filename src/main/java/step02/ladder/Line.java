package step02.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final static int ZERO = 0;
    private final static int ONE = 1;

    private final List<Boolean> point = new ArrayList<>();

    public Line(int xCount) {
        for (int i = ZERO; i < xCount; i++) {
            makeLine(xCount, i);
        }
    }

    private void makeLine(int height, int yPoint) {
        if (yPoint == ZERO) {
            point.add(new DeduplicationLineStrategy().makeFirstLine());
            return;
        }
        if (yPoint < height - ONE) {
            boolean beforePoint = point.get(yPoint - ONE);
            point.add(new DeduplicationLineStrategy().makeLine(beforePoint));
            return;
        }
        if (yPoint >= height - ONE) {
            point.add(new DeduplicationLineStrategy().makeLastLine());
        }
    }

    public boolean isHasLine(int indexPoint) {
        return point.get(indexPoint);
    }
}
