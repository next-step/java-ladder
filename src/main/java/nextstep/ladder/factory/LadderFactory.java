package nextstep.ladder.factory;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LadderFactory {
    private static final int ZERO = 0;

    private static final Random RANDOM = new Random();

    public static Ladder createRandomLadder(int height, int countPerson) {
        List<Line> lines = new ArrayList<>();

        IntStream.range(ZERO, height)
                .forEach(i -> lines.add(createLine(countPerson)));

        return new Ladder(lines);
    }

    private static Line createLine(int countPerson) {
        List<Boolean> points = new ArrayList<>();

        IntStream.range(0, countPerson - 1)
                .forEach(i -> points.add(addPoint(i, points)));

        return new Line(points);
    }

    private static boolean addPoint(int point, List<Boolean> points) {
        if (isPreviousPointConnected(point, points)) {
            return false;
        }
        return RANDOM.nextBoolean();
    }

    private static boolean isPreviousPointConnected(int point, List<Boolean> points) {
        return point > 0 && points.get(point - 1);
    }
}
