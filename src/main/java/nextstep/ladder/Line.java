package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfPerson) {
        int size = countOfPerson - 1;
        this.points = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            if (i > 0 && points.get(i - 1)) {
                points.add(false);
            } else {
                points.add(random.nextBoolean());
            }
        }

    }

    public List<Boolean> getPoints() {
        return points;
    }

}