package nextstep.ladder.domain.ladder;

import nextstep.ladder.util.RandomGenerator;

public class DefaultStrategy implements PointEnableStrategy {

    @Override
    public boolean isEnable() {
        return RandomGenerator.halfBoolean();
    }
}
