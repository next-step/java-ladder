package ladder.domain.ladder;

import ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LadderLine implements Line {
    private static final int LADDER_MARK_NUMBER = 0;
    private static final int LADDER_MARK_WITH_DASH_NUMBER = 1;
    private static final int MARK_RANGE = 2;

    private final List<String> line = new ArrayList<>();

    public LadderLine(int personOfCount) {
        line.add(Mark.ofLadder(LADDER_MARK_NUMBER));
        for (int position = 1; position < personOfCount; position++) {
            drawLadder(position);
        }
    }


    public List<String> getLine() {
        return line;
    }

    private boolean drawLadder(int position) {
        if (line.get(position - 1).equals(Mark.ofLadder(LADDER_MARK_WITH_DASH_NUMBER))) {
            line.add(Mark.ofLadder(LADDER_MARK_NUMBER));
            return false;
        }
        line.add(Mark.ofLadder(random()));
        return true;
    }

    private int random() {
        if ((Math.random() * MARK_RANGE) < LADDER_MARK_WITH_DASH_NUMBER) {
            return LADDER_MARK_NUMBER;
        }
        return LADDER_MARK_WITH_DASH_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine line1 = (LadderLine) o;
        return Objects.equals(line, line1.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }
}
