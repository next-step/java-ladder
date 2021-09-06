package nextstep.ladder;

public class Position {
    private final int MAX_POSITION;
    private int position;

    public Position(int position, int MAX_POSITION) {
        this.MAX_POSITION = MAX_POSITION;
        inputValidation(position);
        this.position = position;
    }

    private void inputValidation(int position) {
        if (position > MAX_POSITION || position < 0) {
            throw new IllegalArgumentException(String.format("0 부터 %d 까지의 위치만 가능합니다.", MAX_POSITION));
        }
    }

    public void move(int nextPosition) {
        if (this.position != MAX_POSITION && nextPosition == this.position) {
            this.position++;
        } else if (this.position != 0 && nextPosition == this.position - 1) {
            this.position--;
        }
    }

    public int value() {
        return position;
    }

    @Override
    public String toString() {
        return String.valueOf(position);
    }
}
