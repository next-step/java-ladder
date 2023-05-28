package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExecuteResults {

    private final List<ExecuteResult> executeResults;

    public ExecuteResults(String[] executeResults) {
        if (executeResults.length == 0) {
            throw new IllegalStateException("실행 결과가 입력되지 않았습니다.");
        }
        this.executeResults = Arrays.stream(executeResults).
                map(ExecuteResult::new).
                collect(Collectors.toList());
    }

    public List<ExecuteResult> value() {
        return executeResults;
    }
}
