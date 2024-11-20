package nextstep.ladder.generator;

import static nextstep.ladder.util.ConsecutiveChecker.isConsecutive;

import java.util.List;

public abstract class NonConsecutiveFlagGenerator {

    public final List<Boolean> create(GeneratorWidthSize generatorWidthSize) {
        List<Boolean> result = createResult(generatorWidthSize);

        if (isConsecutive(result)) {
            throw new IllegalStateException("연속되는 숫자 입니다");
        }

        return result;
    }

    protected abstract List<Boolean> createResult(GeneratorWidthSize generatorWidthSize);

}
