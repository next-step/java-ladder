package ladder;

public class Position {

    private int position;

    public Position(int position) {
        valid(position);
        this.position = position;
    }

    public Position moveLeft() {
        return new Position(position - 1);
    }

    public Position moveRight() {
        return new Position(position + 1);
    }

    public int getPosition() {
        return position;
    }

    private void valid(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 0 이상이어야 합니다.");
        }
    }
}
