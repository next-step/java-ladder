package step02.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final static int ZERO = 0;
    private final static int ONE = 1;

    private final List<Boolean> point = new ArrayList<>();

    public Line(int height, LineStrategy lineStrategy) {
        for (int i = ZERO; i < height; i++) {
            makeLine(height, i, lineStrategy);
        }
    }

    private void makeLine(int height, int yIndex, LineStrategy lineStrategy) {
        boolean beforePoint = true;
        if (yIndex > ZERO) {
            beforePoint = point.get(yIndex - ONE);
        }
        point.add(lineStrategy.makeLine(height - ONE, yIndex, beforePoint));

    }

    public boolean isHasLine(int indexPoint) {
        return point.get(indexPoint);
    }
}
