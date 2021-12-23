package ladder.domain;

public class Position {
    private final int index;

    public Position(int index) {
        this.index = index;
    }

    public int getPosition() {
        return this.index;
    }

    public int findPrizeIndex(Ladder ladder) {
        return ladder.findPrizeIndex(this.index);
    }

    @Override
    public String toString() {
        return "Position{" +
                "index=" + index +
                '}';
    }
}
