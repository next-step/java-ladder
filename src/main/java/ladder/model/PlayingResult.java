package ladder.model;

public class PlayingResult {

    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 1;
    private static final String OVER_MAX_LENGTH_MSG = "결과는 최대 5글자입니다.";
    private static final String UNDER_MIN_LENGTH_MSG = "결과는 최소 1글자입니다.";

    private String result;


    public PlayingResult(String result) {
        validateResult(result);
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    private void validateResult(String result) {
        if (result == null || result.length() < MIN_LENGTH) {
            throw new IllegalArgumentException(UNDER_MIN_LENGTH_MSG);
        }

        if (result.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(OVER_MAX_LENGTH_MSG);
        }
    }


}
