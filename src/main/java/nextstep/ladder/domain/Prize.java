package nextstep.ladder.domain;

public class Prize {

    private final String prize;

    public Prize(String prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return String.format("%5s ", prize);
    }
}
