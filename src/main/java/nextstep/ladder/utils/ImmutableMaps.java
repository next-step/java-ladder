package nextstep.ladder.utils;

import java.util.*;
import java.util.function.Function;

public class ImmutableMaps {
    public static Map<String, String> of(String key, String value) {
        Map<String, String> result = new HashMap<>();
        result.put(key, value);
        return Collections.unmodifiableMap(result);
    }

    public static <T> Map<String, T> ordered(Map<String, T> map, List<String> keyOrder) {
        Map<String, T> treeMap = new TreeMap<>(comparingBy(keyOrder));
        treeMap.putAll(map);
        return Collections.unmodifiableMap(treeMap);
    }

    private static Comparator<String> comparingBy(List<String> names) {
        return Comparator.comparing(
                Function.identity(),
                Comparator.comparingInt(names::indexOf)
        );
    }
}
