package ladder.util;

public final class Random {
    private static final java.util.Random random = new java.util.Random();
    private Random(){
        throw new UnsupportedOperationException();
    }
    public static Boolean createBoolean() {
        return random.nextBoolean();
    }
}
