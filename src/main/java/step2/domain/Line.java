package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    private static final Random RANDOM = new Random();

    public Line(int countOfPerson) {
        points.add(RANDOM.nextBoolean());
        for (int i = 1; i < countOfPerson; i++) {
            if (points.get(i-1)) {
                points.add(Boolean.FALSE);
                continue;
            }
            points.add(RANDOM.nextBoolean());
        }
    }



    public List<Boolean> getPoints() {
        return points;
    }


}
