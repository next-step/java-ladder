package ladder.domain;

public class Position {

    private int position;

    private Position(int currentPosition) {
        this.position = currentPosition;
    }

    public static Position from(int currentPosition) {
      return new Position(currentPosition);
    }

    public boolean isSameWith(int targetPosition) {
        return position == targetPosition;
    }
}
