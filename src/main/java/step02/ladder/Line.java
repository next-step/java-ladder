package step02.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final static int ZERO = 0;
    private final static int ONE = 1;
    private final List<Boolean> point = new ArrayList<>();

    public Line(int lineHeight) {
        for (int i = ZERO; i < lineHeight; i++) {
            makeLine(lineHeight, i);
        }
    }

    private void makeLine(int lineHeight, int yIndex) {
        if (yIndex == ZERO) {
            point.add(new DeduplicationLineStrategy().makeFirstLine());
            return;
        }
        if (yIndex < lineHeight - ONE) {
            boolean beforePoint = point.get(yIndex - ONE);
            point.add(new DeduplicationLineStrategy().makeLine(beforePoint));
            return;
        }
        if (yIndex >= lineHeight - ONE) {
            point.add(new DeduplicationLineStrategy().makeLastLine());
        }
    }

    // 아예 총 false 만 있는 경우는 없어야 함

    public boolean isHasLine(int indexPoint) {
        return point.get(indexPoint);
    }

    public int getLadderHeight() {
        return point.size();
    }
}
