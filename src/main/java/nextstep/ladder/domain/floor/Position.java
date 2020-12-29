package nextstep.ladder.domain.floor;

public class Position {

    private static final int POSITION_MOST_LEFT = 0;
    private static final int MOVE_LEFT = -1;
    private static final int MOVE_RIGHT = 1;

    private int position;
    private final int numberOfPosition;

    public Position(int startingPosition, int numberOfPosition) {
        this.position = startingPosition;
        this.numberOfPosition = numberOfPosition;
    }

    public int getCurrentPosition() {
        return position;
    }

    public void moveLeft() {
        if (position + MOVE_LEFT < getMostLeftPosition()) {
            throw new IllegalArgumentException("더이상 왼쪽으로 갈수 없어요");
        }
        position += MOVE_LEFT;
    }

    public void moveRight() {
        if (position + MOVE_RIGHT > getMostRightPosition()) {
            throw new IllegalArgumentException("더이상 오른쪽으로 갈수 없어요");
        }
        position += MOVE_RIGHT;
    }

    public boolean isMostLeft() {
        return position == getMostLeftPosition();
    }

    public boolean isMostRight() {
        return position == getMostRightPosition();
    }

    private int getMostLeftPosition() {
        return POSITION_MOST_LEFT;
    }

    private int getMostRightPosition() {
        return numberOfPosition - 1;
    }
}
