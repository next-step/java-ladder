package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<Boolean> line;
    private final LineLength length;

    public Line(int lineLength, LineGenerator lineGenerator) {
        this.length = new LineLength(lineLength);
        this.line = lineGenerator.generate(lineLength);

        assertValidLine(this.line);
    }

    public Line(Line line) {
        this.line = line.getLine().stream().collect(Collectors.toUnmodifiableList());
        this.length = line.length;
    }

    private void assertValidLine(List<Boolean> line) {
        boolean prev = false;

        for (Boolean bridge : line) {
            assertNotOverlap(prev, bridge);
            prev = bridge;
        }
    }

    private void assertNotOverlap(boolean prev, boolean cur) {
        String message = "[라인] 겹치는 라인이 있습니다.";
        if (cur && prev) {
            throw new IllegalArgumentException(message);
        }
    }

    public List<Boolean> getLine() {
        return line.stream().collect(Collectors.toUnmodifiableList());
    }

    public int getLength() {
        return length.getLength();
    }
}
