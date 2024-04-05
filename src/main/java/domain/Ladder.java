package domain;

public class Ladder {

    private final Lines lines;

    public Ladder(int playerCount, int height) {
        this(Lines.of(playerCount, height));
    }

    public Ladder(Lines lines) {
        this.lines = lines;
    }

    public void accept(LadderVisitor visitor) {
        lines.accept(visitor);
    }

    public Position getEndPositionByStartPosition(Position startPosition) {
        Position position = startPosition;
        while (position.getY() < lines.getHeight()) {
            Position move = lines.move(position);
            position = new Position(move.getX(), move.getY() + 1);
        }
        return position;
    }
}
