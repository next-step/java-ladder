package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private List<Line> lines;

    private Lines(int lineSize, int height) {

        this.lines = IntStream.range(0, lineSize)
                .mapToObj(lineNumber -> createLine(lineSize, lineNumber, height))
                .collect(Collectors.toList());
    }

    public static Lines of(int lineSize, int height) {

        return new Lines(lineSize, height);
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
}
