package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BooleanGenerator implements Generator {
    Random randomBoolean = new Random();

    @Override
    public boolean generate() {
        return randomBoolean.nextBoolean();
    }

    public List<Boolean> generateLine(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        points.add(generate());
        for (int i = 1; i < countOfPerson - 1; i++) {
            points.add(makeSideLine(points.get(i - 1)));
        }
        return points;
    }

    public Boolean makeSideLine(Boolean points) {
        if (points) {
            return false;
        }
        return generate();

    }
}
