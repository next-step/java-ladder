package ladder.domain;

public class Winning {
    private final String winning;

    public Winning(String winning) {
        this.winning = winning;
    }

    @Override
    public String toString() {
        return String.format("%6s", this.winning);
    }
}
