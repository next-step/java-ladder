package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLine {

    private static final boolean BAR = true;
    private static final boolean BLANK = false;
    private final List<Boolean> points;

    public LadderLine(int sizeOfLadder) {
        this.points = InitializeLadder(sizeOfLadder);
    }

    private List<Boolean> InitializeLadder(int sizeOfLadder) {
        return createPoints(sizeOfLadder);
    }

    private List<Boolean> createPoints(int ladderLength) {

        List<Boolean> result = new ArrayList<>();

        result.add(BAR);
        boolean previousLadder = new Random().nextBoolean();
        result.add(previousLadder);

        for (int index = 1; index < ladderLength - 1; index++) {
            previousLadder = createPoint(previousLadder);
            result.add(BAR);
            result.add(previousLadder);
        }
        result.add(BAR);

        return result;

    }

    private boolean createPoint(boolean previousLadder) {
        return previousLadder ? BLANK : new Random().nextBoolean();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
