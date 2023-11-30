package nextstep.ladder.domain;

import nextstep.ladder.exception.MisMatchNameException;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResult {
    private final Map<Name, Prize> results;

    public LadderResult(Map<Name, Prize> results) {
        this.results = new LinkedHashMap<>(results);
    }

    public Prize result(String name) {
        if (!results.containsKey(new Name(name))) {
            throw new MisMatchNameException(name);
        }
        return results.get(new Name(name));
    }

    public Map<Name, Prize> results() {
        return Collections.unmodifiableMap(results);
    }
}
