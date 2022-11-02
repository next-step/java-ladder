package game.domain.ladder;

import game.util.RandomNumberGenerator;

public class RandomNumberStrategy implements NumberStrategy {
    @Override
    public int generateNumber() {
        return RandomNumberGenerator.randomNumber(2);
    }
}
