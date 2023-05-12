package nextstep.ladder.domain;

import java.util.List;

public class Result {
    private final List<String> results;

    public Result(List<String> results) {
        this.results = results;
    }

    public List<String> results() {
        return results;
    }

    public String result(Position position) {
        return results.get(position.value());
    }
}
