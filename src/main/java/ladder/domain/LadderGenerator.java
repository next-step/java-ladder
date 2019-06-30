package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGenerator {
    private static Random random = new Random();

    public static Ladder ladderGenerator(int height, int countOfPlayers) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(lineGenerator(countOfPlayers - 1));
        }
        return new Ladder(ladder);
    }

    public static Line lineGenerator(int lineCount) {
        List<Boolean> points = new ArrayList<>();
        points.add(random.nextBoolean());
        for (int i = 1; i < lineCount; i++) {
            points.add(frontLineChecker(points.get(i - 1)));
        }
        return new Line(points);
    }

    private static boolean frontLineChecker(boolean point) {
        return point ? false : random.nextBoolean();
    }
}
