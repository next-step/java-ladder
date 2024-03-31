package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<Boolean> line;

    public Line(int numberOfUser, LineGenerator lineGenerator) {
        this.line = lineGenerator.generate(numberOfUser);
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

    public List<Boolean> getLine() {
        return line.stream().collect(Collectors.toUnmodifiableList());
    }
}
