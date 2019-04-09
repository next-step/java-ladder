package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LadderLineMakers {

    public static final int INIT_POINT_VALUE = 0;

    private LadderLineMakers() {
    }

    public static List<Boolean> createLine(int lineCount) {
        List<Boolean> points = new ArrayList<>();
        IntStream.range(0, lineCount)
            .forEach(i -> points.add(randomBooleanPoint(points, i)));
        return points;
    }

     static Boolean randomBooleanPoint(List<Boolean> points, int currentPoint) {
        if (currentPoint == INIT_POINT_VALUE) {
            return false;
        }

        if (compareWithBeforePoint(points, currentPoint)) {
            return false;
        }

        boolean newBooleanPoint = new Random().nextBoolean();
        return newBooleanPoint;
    }

    static Boolean compareWithBeforePoint(List<Boolean> points, int currentPoint) {
        return points.get(currentPoint - 1);
    }

}
