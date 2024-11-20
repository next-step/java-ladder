package nextstep.ladder.domain;

import java.util.List;
import nextstep.ladder.generator.GeneratorWidthSize;
import nextstep.ladder.generator.NonConsecutiveFlagGenerator;

public class NonConsecutiveFlagGeneratorFake extends NonConsecutiveFlagGenerator {

    private final List<Boolean> result;

    public NonConsecutiveFlagGeneratorFake(List<Boolean> result) {
        this.result = result;
    }

    @Override
    protected List<Boolean> createResult(GeneratorWidthSize size) {
        return result;
    }
}
