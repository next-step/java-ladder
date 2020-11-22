package ladder.strategy;

public class FalseStrategy extends Strategy {
    private FalseStrategy() {}

    public static FalseStrategy getInstance() {
        return SingletonHelper.instance;
    }

    @Override
    public Boolean get() {
        return false;
    }

    private static class SingletonHelper {
        private static final FalseStrategy instance = new FalseStrategy();
    }
}
