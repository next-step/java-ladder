package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points;

    public Line(CountOfPerson countOfPerson) {
        points = new ArrayList<>(countOfPerson.value - 1);
        setPoints(countOfPerson);
    }

    private void setPoints(CountOfPerson countOfPerson) {
        Random random = new Random();
        points.add(random.nextBoolean());
        for (int j = 1; j < countOfPerson.value - 1; j++) {
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
