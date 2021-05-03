package nextstep.ladder2.domain;

public class NxBridge {
    private final int index;
    private final Direction direction;

    public NxBridge(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public boolean isEnabled() {
        return direction.isRight();
    }

    public int movePosition() {
        if (direction.isLeft()) {
            return index - 1;
        }
        if (direction.isRight()) {
            return index + 1;
        }
        return index;
    }
}
