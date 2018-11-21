package ladder.domain.ladder;

public class LadderPoint {

    private int position;
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

    public int ladderPositionByMinusValue(int value) {
        return this.position-value;
    }

    public int ladderPositionByPlusValue(int value) {
        return this.position+value;
    }

    public boolean hasPosition(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isNotPosition(int position) {
        return this.position != position;
    }

    @Override
    public boolean equals(Object obj) {
        LadderPoint otherLadderPoint = (LadderPoint)obj;
        if (this.position == otherLadderPoint.getPosition() && this.rightValue == otherLadderPoint.isRightValue()) {
            return true;
        }
        return false;
    }
}
