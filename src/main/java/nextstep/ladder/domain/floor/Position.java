package nextstep.ladder.domain.floor;

public class Position {

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
        if (position - 1 < 0) {
            throw new IllegalArgumentException("더이상 왼쪽으로 갈수 없어요");
        }
        position = position - 1;
    }

    public void moveRight() {
        if (position + 1 >= numberOfPosition) {
            throw new IllegalArgumentException("더이상 오른쪽으로 갈수 없어요");
        }
        position = position + 1;
    }

    public boolean isMostLeft() {
        return position == 0;
    }

    public boolean isMostRight() {
        return position == numberOfPosition - 1;
    }
}