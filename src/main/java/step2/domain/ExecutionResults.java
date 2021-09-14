package step2.domain;

import java.util.Arrays;
import java.util.List;

public class ExecutionResults {
    private final List<String> results;

    public ExecutionResults(String[] results) {
        this.results = Arrays.asList(results);
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(String.format("%-6s", result));
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
