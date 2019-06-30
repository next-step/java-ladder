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
            if (points.get(i - 1)) {
                points.add(false);
                continue;
            }
            if (!points.get(i - 1)) {
                points.add(random.nextBoolean());
            }
        }
        return new Line(points);
    }
}
