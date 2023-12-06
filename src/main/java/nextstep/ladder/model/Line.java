package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {
    private final List<Step> line;

    protected Line(List<Step> line) {
        this.line = line;
    }

    public static Line from(List<Step> line) {
        return new Line(line);
    }

    public int lineSize() {
        return line.size();
    }

    public void updateFirsLineToFalse() {
        List<Step> currentLine = this.line;
        if (currentLine != null && !currentLine.isEmpty()) {
            currentLine.set(0, Step.emptyStep());
        }
    }

    public Stream<Step> line() {
        return this.line.stream();
    }
}
