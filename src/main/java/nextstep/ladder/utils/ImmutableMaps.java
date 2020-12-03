package nextstep.ladder.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMaps {
    public static Map<String, String> of(String key, String value) {
        Map<String, String> result = new HashMap<>();
        result.put(key, value);
        return Collections.unmodifiableMap(result);
    }
}
