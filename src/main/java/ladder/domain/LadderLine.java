package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {

    private static final boolean BAR = true;
    private static final boolean BLANK = false;
    private final List<Boolean> points;

    public LadderLine(int sizeOfLadder, LadderGenerator ladderGenerator) {
        this.points = InitializeLadder(sizeOfLadder, ladderGenerator);
    }

    private List<Boolean> InitializeLadder(int sizeOfLadder, LadderGenerator ladderGenerator) {
        return createPoints(sizeOfLadder, ladderGenerator);
    }

    private List<Boolean> createPoints(int ladderLength, LadderGenerator ladderGenerator) {

        List<Boolean> result = new ArrayList<>();

        result.add(BAR);
        boolean previousLadder = ladderGenerator.generateLadder();
        result.add(previousLadder);

        for (int index = 1; index < ladderLength - 1; index++) {
            previousLadder = createPoint(previousLadder, ladderGenerator);
            result.add(BAR);
            result.add(previousLadder);
        }
        result.add(BAR);

        return result;

    }

    private boolean createPoint(boolean previousLadder, LadderGenerator ladderGenerator) {
        return previousLadder ? BLANK : ladderGenerator.generateLadder();
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int existsSideLadder(int index) {
        if (index == 0 && Boolean.TRUE.equals(points.get(1))) {
            return 2;
        }

        if (index == 0) {
            return index;
        }

        if (index == points.size() - 1 && Boolean.TRUE.equals(points.get(index - 1))) {
            return index - 2;
        }

        if (index == points.size() - 1) {
            return index;
        }

        if (Boolean.TRUE.equals(points.get(index + 1))) {
            return index + 2;
        }

        if (Boolean.TRUE.equals(points.get(index - 1))) {
            return index - 2;
        }

        return index;
    }
}
