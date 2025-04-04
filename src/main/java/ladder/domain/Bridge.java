package ladder.domain;

public class Bridge implements Comparable<Bridge> {
    private final int startPosition;

    public Bridge(int startPosition) {
        this.startPosition = startPosition;
    }

    public boolean isContinuous(Bridge nextBridge) {
        return startPosition + 1 == nextBridge.startPosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    @Override
    public int compareTo(Bridge o) {
        return startPosition - o.startPosition;
    }
}
