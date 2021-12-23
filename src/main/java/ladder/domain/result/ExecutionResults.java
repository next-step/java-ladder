package ladder.domain.result;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ExecutionResults {

    public static final String ERROR_EMPTY_MSG = "리스트가 비어있습니다..";

    private final List<String> results;

    public ExecutionResults(List<String> results) {
        if (Objects.isNull(results) || results.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_MSG);
        }
        this.results = results;
    }

    public String findByIndex(int num) {
        return this.results.get(num);
    }

    public List<String> getResults() {
        return Collections.unmodifiableList(this.results);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExecutionResults that = (ExecutionResults) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

}
