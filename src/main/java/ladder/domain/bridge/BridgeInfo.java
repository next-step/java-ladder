package ladder.domain.bridge;

public class BridgeInfo {
    private int maxLength;
    private int y;

    public BridgeInfo(int maxLength, int y) {
        this.maxLength = maxLength;
        this.y = y;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getY() {
        return y;
    }
}
