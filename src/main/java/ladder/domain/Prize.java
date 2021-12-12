package ladder.domain;

public class Prize {
    private static final String EMPTY_ERROR_MESSAGE = "error : 공백은 사용할수 없습니다.";

    private final String prize;

    public Prize(String prize) {
        checkEmpty(prize);
        this.prize = prize;
    }

    private static void checkEmpty(String prize) {
        if (prize.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }

    public String value() {
        return prize;
    }

}
