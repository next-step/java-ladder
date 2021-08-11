package nextstep.ladder.domain;

public class Position {
    private int moveIndex;

    private Position(int moveIndex) {
        this.moveIndex = moveIndex;
    }

    public static Position of(int moveIndex) {
        return new Position(moveIndex);
    }

    public void rightMove() {
        this.moveIndex += 2;
    }

    public void leftMove() {
        this.moveIndex -= 2;
    }

    public int ceil() {
        return (int) Math.ceil(moveIndex / 2);
    }
}
