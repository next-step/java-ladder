package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGenerator {
    static Random random = new Random();

    public static Line lineGenerator(int input) {
        List<Boolean> points = new ArrayList<>();
        for (int i = 1; i < input; i++) {
            points.add(random.nextBoolean());
        }
        return new Line(points);
    }
}
