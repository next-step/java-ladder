package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResults {
    private final Map<Name, Name> value;

    public LadderResults(Map<Name, Name> results) {
        this.value = new LinkedHashMap<>(results);
    }

    public Name resultOf(String name) {
        return value.get(new Name(name));
    }

    public Name resultOf(Name participant) {
        return value.get(participant);
    }

    public Map<Name, Name> asMap() {
        return value;
    }
}
