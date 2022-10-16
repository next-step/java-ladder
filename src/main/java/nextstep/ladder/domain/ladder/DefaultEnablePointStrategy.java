package nextstep.ladder.domain.ladder;

import nextstep.ladder.util.RandomGenerator;

public class DefaultEnablePointStrategy implements EnablePointStrategy {

    @Override
    public boolean isEnabled() {
        return RandomGenerator.halfBoolean();
    }
}
