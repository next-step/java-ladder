package ladder;

import java.util.Collections;
import java.util.List;

import static util.Preconditions.checkArgument;

public class LadderLine {
    public static final String PERSON_COUNT_MUST_MORE_THEN_ONE = "person count must more then one";
    private final List<Point> points;

    private LadderLine(final List<Point> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public static LadderLine of(final int personCount) {
        checkArgument(personCount >= 1, PERSON_COUNT_MUST_MORE_THEN_ONE);
        return new LadderLine(Collections.emptyList());
    }
}
