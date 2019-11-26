package reladder.domain;

import reladder.service.LadderGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLineGenerator implements LineGenerator {

    private static final Random RANDOM;
    private static final int BOUNDARY_INDEX = 1;

    static {
        RANDOM = new Random();
    }

    private static LadderLineGenerator of() {
        return new LadderLineGenerator();
    }

    public static LadderLineGenerator getInstance() {
        return of();
    }

    @Override
    public LadderLine generate(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = Point.firstNext(randomGenerate());
        points.add(point);

        for (int i = BOUNDARY_INDEX; i < sizeOfPerson - BOUNDARY_INDEX; i++) {
            point = point.next(LadderLineGenerator.randomGenerate());
            points.add(point);
        }
        points.add(point.lastNext());
        return new LadderLine(points);
    }

    public static boolean randomGenerate() {
        return RANDOM.nextBoolean();
    }
}
