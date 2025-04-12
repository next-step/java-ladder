package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Results {
    private final Map<Name, Name> value;

    public Results(Map<Name, Name> results) {
        this.value = new LinkedHashMap<>(results);
    }

    public Map<Name, Name> getResult(String name) {
        return Map.of(new Name(name), value.get(new Name(name)));
    }

    public Map<Name, Name> getAllResult() {
        return value;
    }
}
