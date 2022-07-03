package ladder.domain;

public class SequentialConnectionStrategy implements ConnectingStrategy {
    private static final boolean ALWAYS_TRUE = true;

    @Override
    public boolean connectable() {
        return ALWAYS_TRUE;
    }
}