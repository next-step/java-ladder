package nextstep.step2.dto;

import nextstep.step2.vo.BooleanGenerateStrategy;
import nextstep.step2.vo.Height;
import nextstep.step2.vo.Names;

public class LadderInformation {

    private final Names names;
    private final Height height;
    private final BooleanGenerateStrategy strategy;

    private LadderInformation(Names names, Height height, BooleanGenerateStrategy strategy) {
        this.names = names;
        this.height = height;
        this.strategy = strategy;
    }

    public static LadderInformation create(String namesString, BooleanGenerateStrategy strategy, String heightValue) {
        return new LadderInformation(Names.createWithString(namesString), Height.createWithString(heightValue), strategy);
    }

    public Names getNames() {
        return names;
    }

    public Height getHeight() {
        return height;
    }

    public BooleanGenerateStrategy getStrategy() {
        return strategy;
    }
}
