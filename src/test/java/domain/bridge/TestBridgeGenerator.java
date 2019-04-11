package domain.bridge;

public class TestBridgeGenerator implements BridgeGenerator{
    @Override
    public boolean generate(boolean left) {
        if (left) return Boolean.FALSE;
        return Boolean.TRUE;
    }
}