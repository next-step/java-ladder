package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineFactory {

    private static final Random random = new Random();
    private static final boolean PARTICIPANT_COLUMN = false;
    private static final boolean NO_HORIZONTAL = false;
    private static boolean overlap = false;

    public static Line generate(int participantCount) {
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < participantCount; i++) {
            points.add(PARTICIPANT_COLUMN);
            addHorizontal(points);
        }
        int lastIndex = points.size() - 1;
        points.remove(lastIndex);
        return Line.from(points);
    }

    private static void addHorizontal(List<Boolean> points) {
        if (overlap) {
            points.add(NO_HORIZONTAL);
            overlap = false;
            return;
        }
        points.add(random.nextBoolean());
        if (points.get(points.size() - 1)) {
            overlap = true;
        }
    }
}
