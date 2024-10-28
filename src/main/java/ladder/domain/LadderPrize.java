package ladder.domain;

public class LadderPrize {
    private static final String BLANK_ERROR = "결과는 공백일 수 없습니다.";
    private final String result;

    public LadderPrize(String result) {
        validateIsBlank(result);
        this.result = result;
    }

    private void validateIsBlank(String result) {
        if (result.isEmpty() || result.isBlank()) {
            throw new IllegalArgumentException(BLANK_ERROR);
        }
    }

    public String getResult() {
        return result;
    }
}
