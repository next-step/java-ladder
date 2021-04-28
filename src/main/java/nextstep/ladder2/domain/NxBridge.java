package nextstep.ladder2.domain;

public class NxBridge {
    private final int index;
    private final boolean enabled;

    public NxBridge(int index, boolean enabled) {
        this.index = index;
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public int movePosition(int pointIndex) {
        if (pointIndex > index + 1 || pointIndex < 0) {
            throw new IllegalArgumentException("Bridge와 연결되지 않은 Index 입니다.");
        }
        if (pointIndex == index) {
            return moveLeftToRight(pointIndex);
        }
        return moveRightToLeft(pointIndex);
    }

    private int moveLeftToRight(int pointIndex) {
        if (enabled) {
            return pointIndex + 1;
        }
        return pointIndex;
    }

    private int moveRightToLeft(int pointIndex) {
        if (enabled) {
            return pointIndex - 1;
        }
        return pointIndex;
    }
}
