package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random random = new Random();
    private final List<Boolean> points;

    public Line(int participantsCount) {
        this.points = this.makeLadderLine(participantsCount);
    }

    public List<Boolean> getLine() {
        return this.points;
    }

    private List<Boolean> makeLadderLine(int participantsCount) {
        final List<Boolean> ladderRow = new ArrayList<>();
        ladderRow.add(false);

        for (int i = 0; i < participantsCount - 1; i++) {
            ladderRow.add(makeNextLine(ladderRow.get(ladderRow.size() - 1)));
        }

        return ladderRow;
    }

    private boolean makeNextLine(boolean status) {
        if (status) {
            return false;
        }

        return random.nextBoolean();
    }
}
