package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLevel {
    private final List<Line> lines;

    public LadderLevel(List<Line> lines) {
        this.lines = lines;
    }

    public int getDirection(int startIndex) {
        if (isFirstIndex(startIndex)) {
            return startIndex + getRightLine(startIndex);
        }

        if (startIndex == this.lines.size()) {
            return startIndex + getLeftLine(startIndex);
        }

        return startIndex + getLeftLine(startIndex) + getRightLine(startIndex);
    }

    private static boolean isFirstIndex(int startIndex) {
        return startIndex == 0;
    }

    private int getLeftLine(int startIndex) {
        if (this.lines.get(startIndex - 1).isLine()) {
            return goLeft();
        }
        return stay();
    }

    private int getRightLine(int startIndex) {
        if (this.lines.get(startIndex).isLine()) {
            return goRight();
        }
        return stay();
    }

    private static int goRight() {
        return 1;
    }

    private static int stay() {
        return 0;
    }

    private static int goLeft() {
        return -1;
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
