package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfPerson) {
        points = new ArrayList<>(countOfPerson - 1);
        setPoints(countOfPerson);
    }

    private void setPoints(int countOfPerson) {
        Random random = new Random();
        points.add(random.nextBoolean());
        for (int j = 1; j < countOfPerson - 1; j++) {
            if (points.get(j - 1)) {
                points.add(false);
                continue;
            }
            points.add(random.nextBoolean());
        }
    }

    public int size() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
