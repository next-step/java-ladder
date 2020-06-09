package nextstep.ladder.domain;

public class Bridge {
    private final int lineIndex;
    private final Movement movement;

    private Bridge(int lineIndex, Movement movement) {
        this.validateLineIndex(lineIndex);
        this.lineIndex = lineIndex;
        this.movement = movement;
    }

    private void validateLineIndex(int lineIndex) {
        if (lineIndex < 0) {
            throw new IllegalArgumentException("lineIndex not negative number");
        }
    }

    public static Bridge firstBridge(MovementGenerator movementGenerator) {
        return new Bridge(0, Movement.first(movementGenerator));
    }

    public static Bridge lastBridge(Bridge prevBridge) {
        return new Bridge(prevBridge.lineIndex + 1, Movement.last(prevBridge.movement));
    }

    public static Bridge middleBridge(Bridge prevBridge, MovementGenerator movementGenerator) {
        return new Bridge(prevBridge.lineIndex + 1, Movement.of(prevBridge.movement, movementGenerator));
    }

    public int move() {
        return this.lineIndex + this.movement.move();
    }

    public boolean isRight() {
        return movement.isRight();
    }
}
