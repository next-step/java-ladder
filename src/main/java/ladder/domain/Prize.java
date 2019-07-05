package ladder.domain;

public class Prize {
    static final String ALERT_EXCEED_LENGTH_OF_PRIZE_NAME = "상품은 다섯 글자 이내로 작성해주세요.";
    static final String ALERT_MISSING_PRIZE = "상품명을 입력해주세요.";
    private static final int MAXIMUM_LENGTH_OF_PRIZE_NAME = 5;

    private final String prize;

    private Prize(String inputPrize) {
        validationPrize(inputPrize);
        this.prize = inputPrize;
    }

    public static Prize from(String inputPrize) {
        return new Prize(inputPrize);
    }

    private void validationPrize(String inputPrize) {
        if (inputPrize.isEmpty()) {
            throw new IllegalArgumentException(ALERT_MISSING_PRIZE);
        }
        if (inputPrize.length() > MAXIMUM_LENGTH_OF_PRIZE_NAME) {
            throw new IllegalArgumentException(ALERT_EXCEED_LENGTH_OF_PRIZE_NAME);
        }
    }

    String getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        return "Prize{" +
                "prize='" + prize + '\'' +
                '}';
    }
}
