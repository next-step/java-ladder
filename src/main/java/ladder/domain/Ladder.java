package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;
    private final int heights;

    public Ladder(int lineSize, int heights) {

        if (lineSize <= 0 || heights <= 0) {
            throw new IllegalArgumentException("라인 개수 또는 길이가 유효하지 않습니다.");
        }

        this.lines = IntStream.range(0, lineSize)
                .mapToObj(lineNumber -> createLine(lineSize, lineNumber, heights))
                .collect(Collectors.toList());
        this.heights = heights;
    }

    private Line createLine(int lineSize, int lineNumber, int heights) {

        if (isLastLine(lineSize, lineNumber)) {
            return new Line(heights);
        }
        return new Line(lineNumber, heights);
    }

    private boolean isLastLine(int lineSize, int lineNumber) {

        return lineNumber >= lineSize - 1;
    }

    public List<Line> getLines() {

        return lines;
    }

    public int getHeights() {

        return heights;
    }
}
