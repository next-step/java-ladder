package nextstep;

import nextstep.ladder.RandomBooleanProvider;

public class UniformRandomBooleanProvider implements RandomBooleanProvider {

    private static double RANDOM_RATE = 0.5;
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
        return Math.random() < RANDOM_RATE;
    }
}
