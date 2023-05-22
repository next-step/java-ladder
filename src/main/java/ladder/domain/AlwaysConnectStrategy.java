package ladder.domain;

public class AlwaysConnectStrategy implements ConnectStrategy{
    private static final AlwaysConnectStrategy INSTANCE = new AlwaysConnectStrategy();
    @Override
    public boolean nextBoolean() {
        return true;
    }

    public static AlwaysConnectStrategy getInstance() {
        return INSTANCE;
    }

    private AlwaysConnectStrategy() {}

}
