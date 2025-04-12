package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Results {
    private final Map<Name, Name> value;

    public Results(Map<Name, Name> results) {
        this.value = new LinkedHashMap<>(results);
    }

    public String getResult(String name) {
        return value.get(new Name(name)).toString();
    }

    public String getResult(Name name) {
        return value.get(name).toString();
    }

    public Map<Name, Name> getAllResult() {
        return value;
    }
}
