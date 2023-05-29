package nextstep.step2.domain;

import java.util.List;

public class Result {

    private final List<String> results;

    public Result(List<String> results) {
        this.results = results;
    }

    public String get(int index) {
        return results.get(index);
    }

    public List<String> getResult() {
        return this.results;
    }
}
