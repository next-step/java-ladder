package reladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLineGenerator implements LineGenerator {

    private static final Random RANDOM = new Random();
    private static final int BOUNDARY_INDEX = 1;

    private static LadderLineGenerator ladderLineGenerator = new LadderLineGenerator();

    public static LadderLineGenerator getInstance() {
        return ladderLineGenerator;
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
