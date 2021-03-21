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

    @Override
    public int hashCode() {
        return number;
    }

    public LadderNumber sum(int toSum) {
        return new LadderNumber(number + toSum);
    }

    public int number() {
        return number;
    }
}
