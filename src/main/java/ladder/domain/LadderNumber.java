package ladder.domain;

public class LadderNumber {

    private int number;

    public LadderNumber(int number) {
        if (number < 0) {
            throw new IllegalStateException("0 보다 커야 합니다.");
        }
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LadderNumber that = (LadderNumber) o;

        return number == that.number;
    }

    public LadderNumber leftLadderNumber() {
        return new LadderNumber(number - 1);
    }

    public LadderNumber rightLadderNumber() {
        return new LadderNumber(number + 1);
    }

    @Override
    public int hashCode() {
        return number;
    }

    public LadderNumber next(Line line) {
        int leftPointIndex = number;
        if (line.isFilledAt(leftPointIndex)) {
            return leftLadderNumber();
        }
        int rightPointIndex = number + 1;
        if (line.isFilledAt(rightPointIndex)) {
            return rightLadderNumber();
        }
        return this;
    }
}
