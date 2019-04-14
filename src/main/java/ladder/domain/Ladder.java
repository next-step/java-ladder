package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        verifyHeightOfLadder(lines);
        this.lines = lines;
    }

    private void verifyHeightOfLadder(List<Line> lines) {
        if (lines.size() < 1) {
            throw new IllegalArgumentException("높이가 1미만인 사다리는 생성할 수 없습니다.");
        }
    }

    public int getNumberOfLines() {
        return lines.size();
    }

    public int getCountOfPoints() {
        return getFirstLine().getNumberOfPoints();
    }

    private Line getFirstLine() {
        return lines.get(0);
    }

    public int descend(int i) {
        int index = i;
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }

    @Override
    public String toString() {
        return String.join("\n",
                lines.stream()
                        .map(Line::toString)
                        .collect(Collectors.toList()));
    }
}
