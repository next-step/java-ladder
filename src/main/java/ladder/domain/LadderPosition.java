package ladder.domain;

public class LadderPosition {

    private final LadderLength ladderLength = new LadderLength(0);

    private final Position position;

    public LadderPosition(Position position) {
        this.position = new Position(position.getPosition());
    }


    public void down() {
        this.ladderLength.increase();
    }

    public void next() {
        this.position.increase();
    }

    public void previous() {
        this.position.decrease();
    }

    public boolean isArrived(LadderLength ladderLength) {
        return this.ladderLength.compareTo(ladderLength) >= 0;
    }

    public int length() {
        return ladderLength.getLength();
    }

    public Position getHorizontalPosition() {
        return new Position(position.getPosition());
    }
}
