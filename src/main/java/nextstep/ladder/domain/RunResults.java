package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RunResults {
    private final List<RunResult> runResults;

    public RunResults(String string) {
        this(toRunResults(string));
    }

    public RunResults(List<RunResult> runResults) {
        this.runResults = runResults;
    }

    private static List<RunResult> toRunResults(String string) {
        return Arrays.stream(string.split(","))
                .map(RunResult::new)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.runResults.toString();
    }
}
