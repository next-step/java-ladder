package nextstep.refactor_ladder.domain.value;

import nextstep.ladder.annotations.GetterForUI;
import nextstep.ladder.utils.Preconditions;

import java.util.Objects;

public class ExecutionResult {
    private final String result;

    public ExecutionResult(String result) {
        Preconditions.checkNotNull(result, "result는 필수값입니다.");

        this.result = result;
    }

    public static ExecutionResult from(String result) {
        return new ExecutionResult(result);
    }

    @GetterForUI
    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExecutionResult that = (ExecutionResult) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
