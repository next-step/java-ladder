package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line (int countOfPerson) {
        Random random = new Random();
        for (int i = 0; i < countOfPerson - 1; i++) {
            if (i > 0 && points.get(i - 1)) {
                this.points.add(false);
                continue;
            }
            this.points.add(random.nextBoolean());
        }
    }

    public Line (int countOfPerson, List<Boolean> points) {
        this.points.addAll(points);
    }

    public List<Boolean> getPoints() {
        return List.copyOf(points);
    }
}
