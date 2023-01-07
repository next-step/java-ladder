package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points = new ArrayList<>();
    private static final Random random = new Random();

    public Line(Members members){
        IntStream.range(0, members.getSize() - 1)
                .forEach(i -> points.add(pointAdd(i)));
    }

    public boolean pointAdd(int i){
        boolean point = random.nextBoolean();
        if(i > 0){
            point = pointEqual(i);
        }
        return point;
    }

    private boolean pointEqual(int i) {
        return validPoint(random.nextBoolean(), points.get(i - 1));
    }

    public boolean validPoint(boolean currentPoint, boolean beforePoint){
        if(currentPoint && beforePoint){
            return false;
        }
        return currentPoint;
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
