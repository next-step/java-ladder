package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultInfo {
    private final List<String> result;

    public ResultInfo(String result) {
        this(Arrays.stream(result.split(",")).collect(Collectors.toList()));
    }

    public ResultInfo(List<String> result) {
        this.result = result;
    }

    public List<String> getResult() {
        return result;
    }
}
