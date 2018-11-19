package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PointProvider implements Generator {
    private Random random = new Random();

    @Override
    public List<Boolean> generate(int countOfPerson) {
        List<Boolean> booleanList = new ArrayList<>();
        booleanList.add(generateBoolean());
        for (int i = 1; i < countOfPerson - 1; i++) {
            booleanList.add(makeSideLine(booleanList.get(i - 1)));
        }
        return booleanList;
    }

    private boolean generateBoolean() {
        return random.nextBoolean();
    }

    private Boolean makeSideLine(Boolean points) {
        if (points) {
            return false;
        }
        return generateBoolean();
    }
}
