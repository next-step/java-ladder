package nextstep.ladder.generator;

import java.util.List;
import nextstep.ladder.util.ConsecutiveChecker;

public abstract class NonConsecutiveFlagGenerator {

    public final List<Boolean> create(GeneratorWidthSize generatorWidthSize) {
        List<Boolean> result = createResult(generatorWidthSize);

        if (ConsecutiveChecker.isConsecutive(result)) {
            throw new IllegalStateException("연속되는 숫자 입니다");
        }

        return result;
    }

    protected abstract List<Boolean> createResult(GeneratorWidthSize generatorWidthSize);

}
