package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private static final int MINIMUM_WIDTH = 1;

    private final List<Boolean> line;

    public Line(List<Boolean> line) {
        this.line = line;
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(line);
    }

    public static Line of(int width, LineStrategy lineStrategy) {
        valid(width);
        List<Boolean> line = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            addLine(line, lineStrategy);
        }
        return new Line(line);
    }

    private static void valid(int width) {
        if (width < MINIMUM_WIDTH) {
            throw new IllegalArgumentException(String.format("사다리 게임을 위해서는 라인은 최소 (%d) 이상 이어야 합니다.", MINIMUM_WIDTH));
        }
    }

    private static List<Boolean> addLine(List<Boolean> line, LineStrategy lineStrategy) {
        if (beforeLine(line)) {
            line.add(false);
            return line;
        }
        line.add(lineStrategy.isLine());
        return line;
    }

    private static boolean beforeLine(List<Boolean> line) {
        if (line.isEmpty()) {
            return false;
        }
        return line.get(line.size() - 1);
    }

}
