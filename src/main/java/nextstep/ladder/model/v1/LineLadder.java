package nextstep.ladder.model.v1;

import nextstep.ladder.model.api.Ladder;

import java.util.Iterator;

public class LineLadder implements Iterable<Line>, Ladder {
    public static final int START_HEIGHT = 0;

    private final Lines lines;

    LineLadder(Lines lines) {
        this.lines = lines;
    }

    @Override
    public int climb(int startWidth) {
        int currentWidth = startWidth;

        for (int currentHeight = START_HEIGHT; currentHeight < height(); currentHeight++) {
            currentWidth = getCurrentWidth(currentWidth, currentHeight);
        }

        return currentWidth;
    }

    private int getCurrentWidth(int currentWidth, int currentHeight) {
        if (lines.hasLeftLine(currentWidth)) {
            int newWidth = lines.getLeftLine(currentWidth).goLeftIfCan(currentWidth, currentHeight);
            if (newWidth != currentWidth) {
                return newWidth;
            }
        }
        if (lines.hasRightLine(currentWidth)) {
            return lines.getRightLine(currentWidth).goRightIfCan(currentWidth, currentHeight);
        }
        return currentWidth;
    }

    @Override
    public int height() {
        return lines.height();
    }

    @Override
    public Iterator<Line> iterator() {
        return lines.iterator();
    }
}
