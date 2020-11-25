package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExecutionsResults {
    private final List<String> executionResults;

    private ExecutionsResults(List<String> executionResults) {
        this.executionResults = executionResults;
    }

    public static ExecutionsResults of(List<String> executionResultInput) {
        return new ExecutionsResults(executionResultInput);
    }

    public static ExecutionsResults of(String... executionResultInput) {
        return new ExecutionsResults(Arrays.asList(executionResultInput));
    }

    public int size() {
        return executionResults.size();
    }

    public String get(int i) {
        return executionResults.get(i);
    }

    public void forEach(Consumer<String> consumer) {
        executionResults.forEach(consumer);
    }
}
