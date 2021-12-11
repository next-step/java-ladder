package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private static final int NONE = 0;
    private static final int EXIST = 1;

    private final List<Integer> line;

    private Line(List<Integer> line) {
        this.line = Collections.unmodifiableList(line);
    }

    public static Line from(int nameCount) {
        List<Integer> line = new ArrayList<>();
        for (int i = 0; i < nameCount; i++) {
            line.add(lineValue(beforeLine(line)));
        }
        return new Line(line);
    }

    public static int beforeLine(List<Integer> lineNumber) {
        if (lineNumber.size() == NONE) {
            return LineRandom.random();
        }
        return lineNumber.get(lineNumber.size() - EXIST);
    }

    public static int lineValue(int beforeLine) {
        return beforeLine == NONE ? LineRandom.random() : NONE;
    }

    public int position(int position) {
        return Position.move(position, line)
                .value();
    }

    public int size() {
        return line.size();
    }

    public int value(int index) {
        return line.get(index);
    }

}
