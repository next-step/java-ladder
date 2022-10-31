package game.util;

import java.util.Random;

public class SingletonRandom {
    private SingletonRandom() {

    }

    public static Random getInstance() {
        return LazyHolder.INTANCE;
    }

    public static class LazyHolder {
        private static final Random INTANCE = new Random();
    }
}
