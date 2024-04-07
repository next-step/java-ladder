package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<Boolean> line;
    private final LineLength length;

    public Line(int lineLength, LineGenerator lineGenerator) {
        this.length = new LineLength(lineLength);
        this.line = lineGenerator.generate(this.length);

        assertValidLine(this.line);
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

    public int nextIndex(int index) {


        if (index != getLength() && line.get(index)) {
            return index + 1;
        }

        //왼쪽으로 가야하는 경우
        if (index != 0 && line.get(index - 1)) {
            return index - 1;
        }

        return index;

    }

    public List<Boolean> getLine() {
        return line.stream().collect(Collectors.toUnmodifiableList());
    }

    public int getLength() {
        return length.getLength();
    }
}
