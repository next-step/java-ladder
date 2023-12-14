package nextstep.ladder.domain;

public class Position {

    public static final int FIRST_POSITION = 0;
    private int index;
    private int maxIndex;

    public Position(int index, int maxIndex) {
        this.index = index;
        this.maxIndex = maxIndex;
    }

    public boolean isFirstPosition() {
        return index == FIRST_POSITION;
    }

    public boolean isLastPosition() {
        return index == maxIndex;
    }

    public int leftPosition() {
        return this.index-1;
    }

    public int currentPosition() {
        return this.index;
    }

    public int rightPosition() {
        return this.index+1;
    }
}
