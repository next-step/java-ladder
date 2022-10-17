package ladder.domain;

public class LadderPosition {

    private final LadderLength ladderLength = new LadderLength(0);

    private final HorizontalPosition horizontalPosition;

    private LadderPosition(HorizontalPosition horizontalPosition) {
        this.horizontalPosition = horizontalPosition;
    }

    public static LadderPosition startWithUserPosition(HorizontalPosition position) {
        return new LadderPosition(position);
    }

    public void down() {
        this.ladderLength.increase();
    }

    public void next() {
        this.horizontalPosition.increase();
    }

    public void previous() {
        this.horizontalPosition.decrease();
    }

    public boolean isArrived(LadderLength ladderLength) {
        return this.ladderLength.compareTo(ladderLength) >= 0;
    }

    public int length() {
        return ladderLength.getLength();
    }

    public HorizontalPosition getHorizontalPosition() {
        return horizontalPosition;
    }
}
