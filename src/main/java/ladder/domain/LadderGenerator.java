package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGenerator {
    static Random random = new Random();

    public static Line lineGenerator(int input) {
        List<Boolean> points = new ArrayList<>();
        points.add(random.nextBoolean());
        for (int i = 1; i < input; i++) {
            points.add(frontLineChecker(points.get(i - 1)));
        }
        return new Line(points);
    }

    private static boolean frontLineChecker(boolean point) {
        return point ? false : random.nextBoolean();
    }
}
