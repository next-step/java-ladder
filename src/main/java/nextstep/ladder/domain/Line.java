package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nextstep.ladder.exception.NotEnoughWidthException;

public class Line {

    private static final int MINIMUM_WIDTH = 1;
    private static final int MINUS_INDEX = 1;
    private static final boolean DEFAULT_LINE = false;
    private static final boolean DOUBLE_LINE_PREVENTION = false;

    private final List<Boolean> line;

    public Line(List<Boolean> line) {
        this.line = line;
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(line);
    }

    public Boolean get(int index) {
        try {
            return line.get(index);
        } catch (IndexOutOfBoundsException e) {
            return DEFAULT_LINE;
        }
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
            throw new NotEnoughWidthException(MINIMUM_WIDTH);
        }
    }

    private static void addLine(List<Boolean> line, LineStrategy lineStrategy) {
        if (beforeLine(line)) {
            line.add(false);
            return;
        }
        line.add(lineStrategy.isLine());
    }

    private static boolean beforeLine(List<Boolean> line) {
        return line.isEmpty() ? DOUBLE_LINE_PREVENTION : line.get(line.size() - MINUS_INDEX);
    }

}
