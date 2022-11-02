package game.service;

import game.util.RandomNumberGenerator;

public class RandomNumberStrategy implements NumberStrategy {
    @Override
    public int generateNumber() {
        return RandomNumberGenerator.randomNumber(2);
    }
}
