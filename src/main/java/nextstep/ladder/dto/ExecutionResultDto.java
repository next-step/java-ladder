package nextstep.ladder.dto;

import java.util.Collections;
import java.util.Map;

public class ExecutionResultDto {

    private final Map<String, String> results;

    private ExecutionResultDto(Map<String, String> results) {
        this.results = Collections.unmodifiableMap(results);
    }

    public Map<String, String> getResults() {
        return results;
    }

    public static ExecutionResultDto of(Map<String, String> results) {
        return new ExecutionResultDto(results);
    }

}
