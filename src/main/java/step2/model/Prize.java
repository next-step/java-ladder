package step2.model;

public class Prize {

    private final String prize;

    private Prize(String prize) {
        this.prize = prize;
    }

    public static Prize createPrize(String prize) {
        return new Prize(prize);
    }

    public String getPrize() {
        return prize;
    }
}
