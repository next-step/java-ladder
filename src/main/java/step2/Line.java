package step2;

import java.util.List;

public class Line {
    private final List<Boolean> sideLines;

    public Line(int numberOfUsers, SidelineGenerator sidelineGenerator) {
        sideLines = sidelineGenerator.generate(numberOfUsers - 1);
    }

    public Boolean hasSidelineAt(int at) {
        if (at >= sideLines.size()) {
            throw new IndexOutOfBoundsException("사람 수 보다 큰 위치에 접근할 수 없습니다.");
        }

        return sideLines.get(at);
    }
}
