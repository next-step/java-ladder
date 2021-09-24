package nextstep.ladder.model;

import java.util.Iterator;
import java.util.List;

public class Lines implements Iterable<Line> {
    public static final int MIN_WIDTH = 0;

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public boolean hasRightLine(int currentWidth) {
        return currentWidth < lines.size();
    }

    public Line getRightLine(int width) {
        return lines.get(width);
    }

    public Line getLeftLine(int width) {
        return lines.get(width - 1);
    }

    public boolean hasLeftLine(int currentWidth) {
        return currentWidth > MIN_WIDTH;
    }

    public int height() {
        return lines.get(MIN_WIDTH).height();
    }

    @Override
    public Iterator<Line> iterator() {
        return lines.iterator();
    }
}
