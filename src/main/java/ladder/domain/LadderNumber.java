package ladder.domain;

public class LadderNumber {

    private final int number;

    public LadderNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LadderNumber that = (LadderNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    public LadderNumber leftLadderNumber() {
        return new LadderNumber(number - 1);
    }

    public LadderNumber rightLadderNumber() {
        return new LadderNumber(number + 1);
    }

    public int number() {
        return number;
    }
}
