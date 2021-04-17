package ladder.service;

public class RandomBooleanGenerator implements RandomBoolean {
    private static final int DEFAULT_PROBABILITY = 50;

    @Override
    public boolean randomBoolean() {
        return true;
    }

    @Override
    public boolean randomBoolean(int trueProbability) {
        return true;
    }
}
