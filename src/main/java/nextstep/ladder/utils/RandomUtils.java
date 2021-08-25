package nextstep.ladder.utils;

import java.util.ArrayList;
import java.util.List;

public class RandomUtils {

    public static List<Boolean> getBooleanList(int pointCount) {
        boolean temp = getBoolean();
        List<Boolean> booleans = new ArrayList<>();
        booleans.add(temp);
        for (int i = 1; i < pointCount; i++) {
            if (temp) {
                temp = false;
                booleans.add(false);
                continue;
            }
            temp = getBoolean();
            booleans.add(temp);
        }
        return booleans;
        // TODO: 2021/08/26 리펙토링 필요
    }

    private static Boolean getBoolean() {
        return Math.random() > 0.5;
    }
}
