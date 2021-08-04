package nextstep.ladder.domain.play;

public class PlayerPosition {

    private static final int START = 0;

    private final int position;

    private PlayerPosition(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < START) {
            throw new IllegalArgumentException("position은 0보다 커야합니다");
        }
    }

    public static PlayerPosition of(int position) {
        return new PlayerPosition(position);
    }

    public PlayerPosition moveRight() {
        return new PlayerPosition(position + 1);
    }

    public PlayerPosition moveLeft() {
        return new PlayerPosition(position - 1);
    }

    public int getValue() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerPosition that = (PlayerPosition) o;

        return position == that.position;
    }

    @Override
    public int hashCode() {
        return position;
    }
}
