package ladder.domain;

public class SequentialConnectionStratrgy implements ConnectingStrategy {
    private static final boolean ALWAYS_TRUE = true;

    @Override
    public boolean connectable() {
        return ALWAYS_TRUE;
    }
}