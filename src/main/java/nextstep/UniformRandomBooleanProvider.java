package nextstep;

import nextstep.ladder.RandomBooleanProvider;

public class UniformRandomBooleanProvider implements RandomBooleanProvider {

    @Override
    public boolean get() {
        return Math.random() < 0.5;
    }
}
