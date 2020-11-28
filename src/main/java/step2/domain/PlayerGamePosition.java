package step2.domain;

import step2.exception.NotMoveLeftException;
import step2.exception.NotMoveRightException;

public class PlayerGamePosition {

    private int position;
    private final int playersCount;

    public PlayerGamePosition(int position, int playersCount) {
        this.position = position;
        this.playersCount = playersCount;
    }

    public void move(Direction direction) {
        if (direction == Direction.LEFT) {
            moveLeft();
        }

        if (direction == Direction.RIGHT) {
            moveRight();
        }
    }

    private void moveRight() {
        validMoveRightPosition();
        position++;
    }

    private void moveLeft() {
        validMoveLeftPosition();
        position--;
    }

    private void validMoveLeftPosition() {
        if (position < 1) {
            throw new NotMoveLeftException();
        }
    }

    private void validMoveRightPosition() {
        if (position == playersCount) {
            throw new NotMoveRightException();
        }
    }

    public int getPosition() {
        return position;
    }
}
