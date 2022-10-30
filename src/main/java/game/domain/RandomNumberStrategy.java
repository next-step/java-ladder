package game.domain;

import game.util.RandomNumberGenerator;

public class RandomNumberStrategy implements NumberStrategy {
    @Override
    public int generateNumber() {
        return RandomNumberGenerator.randomNumber(2);
    }
}
