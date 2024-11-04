package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLadderGenerator implements LadderGenerator {

    private static final Random random = new Random();

    @Override
    public Ladder generateLadder(int participantCount, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(createRandomLine(participantCount));
        }
        return new Ladder(lines);
    }

    private Line createRandomLine(int participantCount) {
        List<Point> points = new ArrayList<>();
        boolean left = false;
        boolean right = random.nextBoolean();
        points.add(new Point(left, right));
        for (int cnt = 1; cnt < participantCount; cnt++) {
            left = right;
            right = nextRight(participantCount, cnt, left);
            points.add(new Point(left, right));
        }
        return new Line(points);
    }

    private boolean nextRight(int participantCount, int cnt, boolean previous) {
        return (isLastPosition(participantCount, cnt) || previous) ? false : random.nextBoolean();
    }

    private boolean isLastPosition(int participantCount, int cnt) {
        return cnt + 1 == participantCount;
    }
}
