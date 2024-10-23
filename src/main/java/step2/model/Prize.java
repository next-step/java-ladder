package step2.model;

public class Prize {

    private final static String MAXIMUM_PRIZE_LENGTH_EXCEPTION = "사다리보상은 5자를 초과하면 안됩니다.";
    private final static int MAXIMUM_PRIZE_LENGTH = 5;
    private final String prize;

    private Prize(String prize) {
        confirmPrizeLength(prize);
        this.prize = prize;
    }

    public static Prize createPrize(String prize) {
        return new Prize(prize);
    }

    public String getPrize() {
        return prize;
    }

    //사다리보상의 길이를 체크한다.
    private void confirmPrizeLength(String prize) {
        if (prize.length() > MAXIMUM_PRIZE_LENGTH) {
            throw new IllegalArgumentException(MAXIMUM_PRIZE_LENGTH_EXCEPTION);
        }
    }
}
