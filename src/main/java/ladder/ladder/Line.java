package ladder.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int LADDER_MARK_NUMBER = 0;
    private static final int LADDER_MARK_WITH_DASH_NUMBER = 1;

    private final List<String> line = new ArrayList<>();

    public Line(int personOfCount) {
        line.add(Mark.ofLadder(LADDER_MARK_NUMBER));
        for (int i = 1; i < personOfCount; i++) {
            if (line.get(i - 1).equals(Mark.ofLadder(LADDER_MARK_WITH_DASH_NUMBER))) {
                line.add(Mark.ofLadder(LADDER_MARK_NUMBER));
            } else {
                line.add(Mark.ofLadder(random()));
            }
        }
    }

    public List<String> getLine() {
        return line;
    }

    private int random() {
        if ((Math.random() * 2) < LADDER_MARK_WITH_DASH_NUMBER) {
            return 0;
        }
        return LADDER_MARK_WITH_DASH_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line1 = (Line) o;
        return Objects.equals(line, line1.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }
}
