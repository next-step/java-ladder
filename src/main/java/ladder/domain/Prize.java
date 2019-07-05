package ladder.domain;

public class Prize {

    private final String prize;

    private Prize(String prize) {
        this.prize = prize;
    }

    public static Prize from(String inputPrize) {
        return new Prize(inputPrize);
    }

    public String getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        return "Prize{" +
                "prize='" + prize + '\'' +
                '}';
    }
}
