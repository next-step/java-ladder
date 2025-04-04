package ladder.domain;

public class Bridge {
    private final int startPosition;

    public Bridge(int startPosition) {
        this.startPosition = startPosition;
    }

    public boolean isContinuous(Bridge nextBridge) {
        return startPosition + 1 == nextBridge.startPosition;
    }
}
