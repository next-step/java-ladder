package nextstep.ladder.generator;

import static nextstep.ladder.domain.ConsecutiveChecker.isConsecutive;

import java.util.List;

public abstract class NonConsecutiveFlagGenerator {

    public final List<Boolean> create(LadderWidthSize ladderWidthSize) {
        List<Boolean> result = createResult(ladderWidthSize);

        if (isConsecutive(result)) {
            throw new IllegalStateException("연속되는 숫자 입니다");
        }

        return result;
    }

    protected abstract List<Boolean> createResult(LadderWidthSize ladderWidthSize);

}
