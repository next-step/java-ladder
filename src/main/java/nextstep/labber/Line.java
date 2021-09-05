package nextstep.labber;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int LADDER_DIFFERENCES_VALUE = 1;
    private static final int INDEX_SIZE_DIFFERENCES_VALUE = 1;
    private static final int MIN_POINTS_SIZE = 0;

    private final List<Boolean> points = new ArrayList<>();

    public Line(int participantsCount) {
        for (int i = 0; i < participantsCount - LADDER_DIFFERENCES_VALUE; i++) {
            points.add(createPoint());
        }
    }

    protected boolean createPoint() {
        SecureRandom random = new SecureRandom();
        if (points.size() != MIN_POINTS_SIZE && points.get(points.size() - INDEX_SIZE_DIFFERENCES_VALUE)) {
            return false;
        }
        return random.nextBoolean();
    }

    public int size() {
        return this.points.size();
    }

    public boolean existLine(int index) {
        return this.points.get(index);
    }
}
