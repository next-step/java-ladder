package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    private static final Random RANDOM = new Random();

    public Line(int countOfPerson) {
        for (int i = 0; i < countOfPerson; i++) {
            points.add(RANDOM.nextBoolean());
        }
    }
}
