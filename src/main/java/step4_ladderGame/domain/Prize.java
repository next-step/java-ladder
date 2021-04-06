package step4_ladderGame.domain;

public class Prize {

    private final String prize;

    private Prize(String prize) {
        this.prize = prize;
    }

    public static Prize of(String prize) {
        return new Prize(prize);
    }

    public String toString() {
        return prize;
    }

}
