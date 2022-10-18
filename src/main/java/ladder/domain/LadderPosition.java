package ladder.domain;

public class LadderPosition {

    private final LadderLength ladderLength = new LadderLength(0);

    private final HorizontalPosition horizontalPosition;

    public LadderPosition(HorizontalPosition horizontalPosition) {
        this.horizontalPosition = new HorizontalPosition(horizontalPosition.getPosition());
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
        return new HorizontalPosition(horizontalPosition.getPosition());
    }
}
