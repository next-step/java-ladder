package nextstep.ladder.domain;

public class Line {

    private final boolean line;

    public Line(boolean line) {
        this.line = line;
    }

    public boolean hasLine() {
        return line;
    }

    public int judgeDirection(Line previousLine) {
        if (previousLine.hasLine()) {
            return 1;
        }

        return judgeDirectionByCurrent();
    }

    private int judgeDirectionByCurrent() {
        if (line) {
            return -1;
        }
        return 0;
    }
}
