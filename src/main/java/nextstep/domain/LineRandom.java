package nextstep.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineRandom implements LineCreateStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public List<Point> create(int count) {
        List<Point> line = new ArrayList<>();
        setLine(count, line);
        return line;
    }

    private void setLine(int count, List<Point> line) {
        Point point = Point.first(RANDOM.nextBoolean());
        line.add(point);
        boolean beforePosition = line.get(0).isRight();
        for (int position = 1; position < count - 1; position++) {
            boolean currentPosition = RANDOM.nextBoolean();

            if (beforePosition) {
                point = point.next(false);
                line.add(point);
                beforePosition = false;
                continue;
            }
            point = point.next(currentPosition);
            line.add(point);
            beforePosition = currentPosition;
        }
        line.add(point.last());
    }
}
