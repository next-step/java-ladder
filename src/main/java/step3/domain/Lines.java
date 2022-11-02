package step3.domain;

import java.util.List;

public class Lines {
    private final List<Boolean> lines;

    public Lines(List<Boolean> lines) {
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
        if (this.lines.get(startIndex - 1)) {
            return -1;
        }
        return 0;
    }

    private int getRightLine(int startIndex) {
        if (this.lines.get(startIndex)) {
            return 1;
        }
        return 0;
    }

    public List<Boolean> getLines() {
        return lines;
    }
}
