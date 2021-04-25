package step02.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();
    private final LineCount yCount;
    private final LineCount xCount;

    public Ladder(int xCount, int yCount, LineStrategy lineStrategy) throws IllegalAccessException {
        this.yCount = new LineCount(yCount);
        this.xCount = new LineCount(xCount);

        for (int i = 0; i < yCount; i++) {
            lines.add(new Line(xCount, lineStrategy));
        }
    }

    public int getYLineCount() {
        return yCount.getCount();
    }

    public int getXLineCount() {
        return xCount.getCount();
    }

    public List<Line> getLadderLine() {
        return lines;
    }
}

