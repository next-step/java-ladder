package nextstep.ladder.domain;

import java.util.Map;

public class LadderResult {

    private Map<Name, Result> results;

    public LadderResult(Map<Name, Result> results) {
        this.results = results;
    }

    public Result result(Name name) {
        return this.results.get(name);
    }

    public Map<Name, Result> results() {
        return results;
    }
}
