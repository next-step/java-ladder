package nextstep.ladder.domain.user;

public class Position {

    private final int currentPosition;

    public Position(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Position move(int movePoint) {
        return new Position(currentPosition + movePoint);
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

}
