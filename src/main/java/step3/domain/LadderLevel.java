package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLevel {
    private final List<Line> lines;

    public LadderLevel(List<Line> lines) {
        this.lines = lines;
    }

    public int getDirection(int startIndex) {
        if (startIndex == 0) {
            return startIndex + getRightLine(startIndex);
        }

        if (startIndex == this.lines.size()) {
            return startIndex + getLeftLine(startIndex);
        }

        return startIndex + getLeftLine(startIndex) + getRightLine(startIndex);
    }

    private int getLeftLine(int startIndex) {
        if (this.lines.get(startIndex - 1).isLine()) {
            return -1;
        }
        return 0;
    }

    private int getRightLine(int startIndex) {
        if (this.lines.get(startIndex).isLine()) {
            return 1;
        }
        return 0;
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
