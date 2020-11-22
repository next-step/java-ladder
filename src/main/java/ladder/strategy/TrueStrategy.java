package ladder.strategy;

public class TrueStrategy extends Strategy {
    private TrueStrategy() {}

    public static TrueStrategy getInstance() {
        return SingletonHelper.instance;
    }

    @Override
    public Boolean get() {
        return true;
    }

    private static class SingletonHelper {
        private static final TrueStrategy instance = new TrueStrategy();
    }
}
