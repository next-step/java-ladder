package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PointGenerator {
    private static final List<Boolean> POINTS = Arrays.asList(true, false);
    private static final int POINT_INDEX = 0;

    public static boolean generateDirection() {
        Collections.shuffle(POINTS);

        return POINTS.get(POINT_INDEX);
    }
}
