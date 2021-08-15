package step3;

import step3.util.SidelineGenerator;

import java.util.List;

public class Line {
    private final List<Boolean> sideLines;

    public Line(SidelineGenerator sidelineGenerator) {
        sideLines = sidelineGenerator.generate();
    }

    public Boolean hasSidelineAt(int at) {
        if (at >= sideLines.size()) {
            throw new IndexOutOfBoundsException("사람 수 보다 큰 위치에 접근할 수 없습니다.");
        }

        return sideLines.get(at);
    }
}
