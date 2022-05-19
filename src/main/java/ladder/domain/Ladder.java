package ladder.domain;

import java.util.List;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("사다리 라인들이 존재하지 않습니다.");
        }
        this.lines = lines;
    }

    public static Ladder from(List<Line> lines) {
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return List.copyOf(lines); // 방어적 복사
    }
}
