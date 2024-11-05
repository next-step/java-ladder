package ladder.domain;

public class FakeConnectionStrategy implements ConnectionStrategy {
    private final boolean fixedConnect;

    public FakeConnectionStrategy(boolean fixedConnect) {
        this.fixedConnect = fixedConnect;
    }

    @Override
    public boolean isConnect() {
        return fixedConnect;
    }
}
