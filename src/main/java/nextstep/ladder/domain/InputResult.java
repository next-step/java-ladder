package nextstep.ladder.domain;

public class InputResult {
    private static final String COMMA_DELIMITER = ",";
    private String results;

    private InputResult(String results) {
        this.results = results;
    }

    public static InputResult createInputResult(String results, int usersNumber) {
        InputResult inputResult = new InputResult(results);
        validateSplitSize(inputResult, usersNumber);
        return inputResult;
    }

    private static void validateSplitSize(InputResult inputResult, int usersNumber) {
        if(inputResult.splitResults().length != usersNumber) {
            throw new IllegalArgumentException("참가자 수와 일치해야 합니다.");
        }
    }

    public String[] splitResults() {
        return results.split(COMMA_DELIMITER);
    }
}
