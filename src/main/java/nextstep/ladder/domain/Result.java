package nextstep.ladder.domain;

import java.util.List;

public class Result {

    private List<String> results;

    public Result(String results) {
        this.results = splitResult(results);
    }

    public List<String> results() {
        return results;
    }

    public String result(int index) {
        return results.get(index);
    }

    private List<String> splitResult(String results) {
        return List.of(results.split(","));
    }


}
