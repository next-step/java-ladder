package ladder.domain.result;

import java.util.List;
import java.util.Objects;

public class ExecutionResults {

    public static final String ERROR_EMPTY_MSG = "리스트가 비어있습니다..";
    private final List<String> results;

    public ExecutionResults(List<String> results) {
        if (results == null || results.size() == 0) {
            throw new IllegalArgumentException(ERROR_EMPTY_MSG);
        }
        this.results = results;
    }

    public List<String> getResults() {
        return results;
    }

    public String getResults(int index) {
        return results.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExecutionResults result = (ExecutionResults) o;
        return Objects.equals(results, result.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

}
