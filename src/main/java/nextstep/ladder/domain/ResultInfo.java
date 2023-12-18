package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultInfo {
    private final List<String> results;

    public ResultInfo(String result) {
        this(Arrays.stream(result.split(",")).collect(Collectors.toList()));
    }

    public ResultInfo(List<String> result) {
        this.results = result;
    }

    public List<String> getResults() {
        return results;
    }

    public String getResult(int position) {
        return results.get(position);
    }
}
