package nextstep.ladder.dto;

import nextstep.ladder.domain.ExecutionResult;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class ExecutionResultDto {

    private final Map<String, String> results;

    private ExecutionResultDto(Map<String, String> results) {
        this.results = Collections.unmodifiableMap(results);
    }

    public static ExecutionResultDto from(ExecutionResult result) {
        return result.getResults().entrySet().stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toUnmodifiableMap(
                                entry -> entry.getKey().getName(),
                                entry -> entry.getValue().toString()
                        ), ExecutionResultDto::new
                ));
    }

    public Map<String, String> getResults() {
        return results;
    }

}

