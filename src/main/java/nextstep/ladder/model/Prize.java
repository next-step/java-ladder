package nextstep.ladder.model;

public class Prize {
    private String prize;

    public Prize(String prize) {
        this.prize = prize;
    }

    public String getNameFormatted() {
        return String.format("%6s", prize);
    }

    public String getPrize() {
        return prize;
    }
}
