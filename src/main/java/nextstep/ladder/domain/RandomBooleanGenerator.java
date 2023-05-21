package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomBooleanGenerator {

    private static List<Boolean> booleanList = new ArrayList<>(2);

    static {
        booleanList.add(Boolean.TRUE);
        booleanList.add(Boolean.FALSE);
    }

    private RandomBooleanGenerator() {
    }

    static boolean getRandomBoolean() {
        Collections.shuffle(booleanList);
        return booleanList.get(0);
    }
}
