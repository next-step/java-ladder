package nextstep;

import nextstep.ladder.RandomBooleanProvider;

public class UniformRandomBooleanProvider implements RandomBooleanProvider {

    private static UniformRandomBooleanProvider INSTANCE;

    public static UniformRandomBooleanProvider getInstance() {
        if (INSTANCE == null) {
            synchronized (UniformRandomBooleanProvider.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UniformRandomBooleanProvider();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public boolean get() {
        return Math.random() < 0.5;
    }
}
