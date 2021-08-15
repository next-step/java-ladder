package step3;

import step3.util.SidelineGenerator;

import java.util.List;

public class Line {
    private final static int OFFSET_LEFT = -1;
    private final static int OFFSET_RIGHT = 0;

    private final List<Boolean> sideLines;

    public Line(SidelineGenerator sidelineGenerator) {
        sideLines = sidelineGenerator.generate();
    }

    public Boolean hasSidelineAt(int at) {
        if (isIndexOutOfBound(at)) {
            return false;
        }

        return sideLines.get(at);
    }

    private boolean isIndexOutOfBound(int at) {
        return at < 0 || at >= sideLines.size();
    }

    public Position sideMove(Position currentPosition) {
        if (hasSidelineAt(currentPosition.getValue() + OFFSET_LEFT)) {
            return currentPosition.toLeft();
        }

        if (hasSidelineAt(currentPosition.getValue() + OFFSET_RIGHT)) {
            return currentPosition.toRight();
        }

        return currentPosition.just();
    }
}
