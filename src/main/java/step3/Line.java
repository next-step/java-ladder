package step3;

import step3.util.SidelineGenerator;

import java.util.List;

public class Line {
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
}
