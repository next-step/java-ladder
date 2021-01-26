package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomGeneratorPoint {

    private static final List<Boolean> flagList = new ArrayList<>(Arrays.asList(true, false));

    private RandomGeneratorPoint() { }

    public static boolean generatorRandomPoint() {
        Collections.shuffle(flagList);

        return flagList.get(0);
    }
}
