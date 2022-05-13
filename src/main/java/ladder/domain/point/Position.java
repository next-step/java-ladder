package ladder.domain.point;

public class Position {
    static final int INITIAL_POSITION = 0;

    private final int position;

    public Position(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < INITIAL_POSITION) {
            throw new IllegalArgumentException(String.format("position(%s)은 초기값(%s) 미만 일 수 없습니다.", position, INITIAL_POSITION));
        }
    }

    public static Position value(int position) {
        return new Position(position);
    }

    public static Position initialize() {
        return new Position(INITIAL_POSITION);
    }

}
