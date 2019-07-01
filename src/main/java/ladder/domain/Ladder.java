package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;
    private final int height;

    public Ladder(int lineSize, int height) {

        if (lineSize <= 0 || height <= 0) {
            throw new IllegalArgumentException("라인 개수 또는 길이가 유효하지 않습니다.");
        }

        this.lines = IntStream.range(0, lineSize)
                .mapToObj(lineNumber -> createLine(lineSize, lineNumber, height))
                .collect(Collectors.toList());
        this.height = height;
    }

    private Line createLine(int lineSize, int lineNumber, int height) {

        if (isLastLine(lineSize, lineNumber)) {
            return Line.ofLastLine(height);
        }
        return Line.of(lineNumber, height);
    }

    private boolean isLastLine(int lineSize, int lineNumber) {

        return lineNumber >= lineSize - 1;
    }

    public List<Line> getLines() {

        return Collections.unmodifiableList(lines);
    }

    public int getHeight() {

        return height;
    }
}
