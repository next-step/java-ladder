package nextstep.domain;

import java.util.List;
import java.util.stream.Stream;

public class Result {
    private List<String> result;

    public Result(List<String> result) {
        this.result = result;
    }

    public String get(int idx) {
        return result.get(idx);
    }

    public Stream<String> stream() {
        return result.stream();
    }
}
