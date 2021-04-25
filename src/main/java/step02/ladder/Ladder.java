package step02.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();
    private final LineCount yCount;
    private final LineCount xCount;

    public Ladder(int xCount, int yCount) throws IllegalAccessException {
        this.yCount = new LineCount(yCount);
        this.xCount = new LineCount(xCount);

        for (int i = 0; i < yCount; i++) {
            lines.add(new Line(xCount, new DeduplicationLineStrategy()));
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

    public boolean isHasLine(int xPoint, int yPoint) {
        return lines.get(yPoint).isHasLine(xPoint);
    }

    public boolean isUserHasLine(int xPoint) {
        return lines.stream().noneMatch(line -> line.isHasLine(xPoint));
    }
}

