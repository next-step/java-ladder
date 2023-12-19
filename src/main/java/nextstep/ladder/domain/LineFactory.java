package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineFactory {
    public static Line randomCreate(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        points.add(getRandomBoolean());
        for (int i = 1; i < countOfPerson - 1; i++) {
            if (points.get(i - 1)) {
                points.add(Boolean.FALSE);
                continue;
            }
            points.add(getRandomBoolean());
        }
        return new Line(points);
    }

    private static boolean getRandomBoolean(){
        Random random = new Random();
        return random.nextBoolean();
    }
}
