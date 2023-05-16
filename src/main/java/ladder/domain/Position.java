package ladder.domain;

public class Position {
    private static final String EXCEPTION_MESSAGE_POSITION = "유저의 위치가 음수일 수는 없습니다.";
    private static final int MIN_POSITION = 0;
    private final int position;

    private Position(int position) {
        validatePosition(position);

        this.position = position;
    }

    public static Position firstPosition() {
        return new Position(MIN_POSITION);
    }

    public int currentPosition() {
        return position;
    }

    public Position moveNext() {
        return new Position(position + 1);
    }

    public Position movePrevious() {
        return new Position(position - 1);
    }

    private void validatePosition(int position) {
        if (position < MIN_POSITION) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_POSITION);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        Position position1 = (Position) o;

        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return position;
    }

}
