package ladder.domain.ladder;

public class LadderPoint {

    int position;
    private boolean rightValue;

    public LadderPoint(int position, boolean rightValue) {
        this.position = position;
        this.rightValue = rightValue;
    }

    public boolean isRightValue() {
        return this.rightValue;
    }

    @Override
    public String toString() {
        if (this.rightValue) {
            return "-----|";
        }

        return "     |";
    }

    public boolean hasPosition(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return this.position;
    }
}
