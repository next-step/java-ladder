package nextstep.ladder.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

public class Ladder implements Iterable<Line> {
    public static final int START_HEIGHT = 0;
    public static final int MIN_WIDTH = 0;

    private final Line[] lines;

    public Ladder(int width, int height) {
        this.lines = IntStream.range(0, width - 1)
            .mapToObj(unused -> new Line(height))
            .toArray(Line[]::new);
    }

    public void drawSteps(DrawStrategy drawStrategy) {
        for (int width = MIN_WIDTH; hasRightLine(width); width++) {
            getRightLine(width).drawSteps(drawStrategy, hasLeftLine(width) ? getLeftLine(width) : null);
        }
    }

    private Line getRightLine(int width) {
        return lines[width];
    }

    private boolean hasRightLine(int currentWidth) {
        return currentWidth < width();
    }

    private Line getLeftLine(int width) {
        return lines[width - 1];
    }

    private boolean hasLeftLine(int currentWidth) {
        return currentWidth > MIN_WIDTH;
    }

    public int height() {
        return lines[MIN_WIDTH].height();
    }

    private int width() {
        return lines.length;
    }

    public int climb(int startWidth) {
        int currentWidth = startWidth;

        for (int currentHeight = START_HEIGHT; currentHeight < height(); currentHeight++) {
            currentWidth = getCurrentWidth(currentWidth, currentHeight);
        }

        return currentWidth;
    }

    private int getCurrentWidth(int currentWidth, int currentHeight) {
        if (hasLeftLine(currentWidth)) {
            int newWidth = getLeftLine(currentWidth).goLeftIfCan(currentWidth, currentHeight);
            if (newWidth != currentWidth) {
                return newWidth;
            }
        }
        if (hasRightLine(currentWidth)) {
            return getRightLine(currentWidth).goRightIfCan(currentWidth, currentHeight);
        }
        return currentWidth;
    }

    @Override
    public Iterator<Line> iterator() {
        return Arrays.stream(lines).iterator();
    }
}
