package domain;

import util.RandomNumberGenerator;

public class RandomNumberLottery implements Lottery {
    @Override
    public boolean test() {
        return RandomNumberGenerator.nextInt(0, 1).equals(0);
    }
}
