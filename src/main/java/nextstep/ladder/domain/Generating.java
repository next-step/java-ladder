package nextstep.ladder.domain;

import java.util.List;

public class Generating {

    public static final String INVALID_PARAMETER_GENERABLE_STRATEGY = "generableStrategy cannot be null";

    private GenerableStrategy generableStrategy;

    public List<Boolean> generate(int length) {
        return generableStrategy.generate(length);
    }

    public Generating(GenerableStrategy generableStrategy) {
        if (generableStrategy == null) {
            throw new IllegalArgumentException(INVALID_PARAMETER_GENERABLE_STRATEGY);
        }
        this.generableStrategy = generableStrategy;
    }
}
