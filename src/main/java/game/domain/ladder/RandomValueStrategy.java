package game.domain.ladder;

import game.util.RandomValueGenerator;

public class RandomValueStrategy implements ValueStrategy {
    @Override
    public int generateNumber() {
        return RandomValueGenerator.randomNumber(2);
    }

    @Override
    public boolean generateBoolean() {
        return RandomValueGenerator.randomBoolean();
    }
}
