package nextstep.ladder.domain;

import java.util.Objects;

public class RunResult {
    private final String runResult;

    public RunResult(String runResult) {
        this.runResult = runResult;
    }

    @Override
    public String toString() {
        return this.runResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RunResult runResult1 = (RunResult) o;
        return Objects.equals(runResult, runResult1.runResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(runResult);
    }
}
