package nextstep.ladder;

import java.util.HashMap;
import java.util.Map;

public class Report {
    private final Map<String, String> result;

    public Report(Map<String, String> result) {
        this.result = result;
    }

    public Map<String, String> getResult() {
        return new HashMap<>(result);
    }

    public boolean containsName(String name) {
        return result.containsKey(name);
    }

    public String findResultByName(String name) {
        if (!result.containsKey(name)) {
            throw new IllegalArgumentException("해당 이름의 결과가 존재하지 않습니다.");
        }

        return result.get(name);
    }
}
