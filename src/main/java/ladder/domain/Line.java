package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int NONE = 0;
    private static final int EXIST = 1;

    private final List<Integer> line;

    private Line(List<Integer> line) {
        this.line = line;
    }

    public static Line from(int nameCount) {
        List<Integer> line = new ArrayList<>();
        for (int i = 0; i < nameCount; i++) {
            line.add(lineValue(beforeLine(line)));
        }
        return new Line(line);
    }

    public static int beforeLine(List<Integer> lineNumber) {
        return lineNumber.size() == NONE ? LineRandom.random() : lineNumber.get(lineNumber.size() - EXIST);
    }

    public static int lineValue(int beforeLine) {
        return beforeLine == NONE ? LineRandom.random() : NONE;
    }

    public int position(int position) {
        boolean left = isPosition(() -> position != 0 && line.get(position - 1) == 1);
        boolean right = isPosition(() -> position != line.size() - 1 && line.get(position) == 1);

        return position - move(left) + move(right);
    }

    public boolean isPosition(Movable movable) {
        return movable.position();
    }

    public int move(boolean line) {
        return line ? EXIST : NONE;
    }

    public int size() {
        return line.size();
    }

    public int value(int index) {
        return line.get(index);
    }

}
