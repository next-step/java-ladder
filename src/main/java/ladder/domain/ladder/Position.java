package ladder.domain.ladder;

public class Position {
    private final int position;

    public Position(int value) {
        if (value < 0) {
            throw new IllegalStateException("Position 은 음수 일 수 없습니다.");
        }
        this.position = value;
    }

    public Position right() {
        return new Position(position + 1);
    }

    public Position left() {
        return new Position(position - 1);
    }

    public int getPosition() {
        return position;
    }
}
