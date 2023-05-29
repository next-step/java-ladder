package nextstep.ladder.domain;

import java.util.Map;

public class Result {

    private final Map<String, String> result;

    public Result(Map<String, String> result) {
        this.result = result;
    }

    public Map<String, String> value() {
        return this.result;
    }
}
