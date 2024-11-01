package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGenerator {

    private static final Random random = new Random();

    private LadderGenerator() {
    }

    public static Ladder generateLadder(int participantCount, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(createRandomLine(participantCount));
        }
        return new Ladder(lines);
    }

    private static Line createRandomLine(int participantCount) {
        List<Point> points = new ArrayList<>();
        boolean left = false;
        boolean right = random.nextBoolean();
        points.add(new Point(left, right));
        for (int cnt = 1; cnt < participantCount; cnt++) {
            left = right;
            right = (cnt == participantCount - 1 || left) ? false : random.nextBoolean();
            points.add(new Point(left, right));
        }
        return new Line(points);
    }
}
