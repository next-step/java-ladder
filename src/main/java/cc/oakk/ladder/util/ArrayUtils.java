package cc.oakk.ladder.util;

import java.util.List;

public class ArrayUtils {
    public static boolean[] toPrimitiveArray(final List<Boolean> booleans) {
        final boolean[] primitives = new boolean[booleans.size()];
        int index = 0;
        for (Boolean object : booleans) {
            primitives[index++] = object;
        }
        return primitives;
    }
}
