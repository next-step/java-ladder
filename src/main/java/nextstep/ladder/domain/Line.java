package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int MIN_LINE_SIZE = 1;

    private final List<Column> line;

    private Line(List<Column> line) {
        validateLineSize(line);
        this.line = line;
    }

    public static Line from(List<Column> line) {
        return new Line(line);
    }

    private static void validateLineSize(List<Column> line) {
        if (Objects.isNull(line) || line.size() < MIN_LINE_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public int move(int index) {
        Column column = line.get(index);
        return column.move(index);
    }

    public List<Column> getLine() {
        return Collections.unmodifiableList(line);
    }
}
