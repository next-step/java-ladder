package nextstep.ladder.domain;

import java.util.Map;

public class Result {

    private final Map<String, String> result;

    public Result(Map<String, String> result) {
        this.result = result;
    }

    public String get(String person) {
        if (result.get(person) == null) {
            throw new IllegalArgumentException("해당하는 사람이 존재하지 않습니다.");
        }
        return result.get(person);
    }

    public Map<String, String> value() {
        return this.result;
    }
}
