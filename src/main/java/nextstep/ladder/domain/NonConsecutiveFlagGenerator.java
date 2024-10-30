package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

public abstract class NonConsecutiveFlagGenerator {

    public final List<Boolean> create() {
        List<Boolean> reuslt = createResult();

        if (isConsecutive(reuslt)) {
            throw new IllegalStateException("연속되는 숫자 입니다");
        }

        return reuslt;
    }

    protected abstract List<Boolean> createResult();

    private boolean isConsecutive(List<Boolean> lines) {
        return IntStream.range(0, lines.size() - 1).anyMatch(i -> lines.get(i) && lines.get(i + 1));
    }
}
