package nextstep.ladder.domain;

import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        validate(lines);
        this.lines = lines;
    }

    private void validate(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }
    }

    public int getHeight() {
        return lines.size();
    }

    public Line getLine(int targetHeight) {
        return lines.get(targetHeight);
    }
}
