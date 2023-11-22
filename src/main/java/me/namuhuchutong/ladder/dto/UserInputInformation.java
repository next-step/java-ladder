package me.namuhuchutong.ladder.dto;

public class UserInputInformation {

    private static final String NOT_NUMERIC_AND_COMMA_REGEX = "^[A-Za-z,]+$";
    private static final int MINIMUM_HEIGHT = 0;
    private static final int MAXIMUM_HEIGHT = 10;
    private static final String COMMA_REGEX = ",";
    private static final String WHITE_SPACE = " ";

    private final String inputNames;

    private final int ladderHeight;

    private final String inputResults;

    public UserInputInformation(String inputNames,  String inputResults, int ladderHeight) {
        validateNames(inputNames);
        validateHeight(ladderHeight);
        validateResults(inputResults);
        validateNamesAndResultsLength(inputNames, inputResults);
        this.inputNames = inputNames;
        this.ladderHeight = ladderHeight;
        this.inputResults = inputResults;
    }

    private void validateResults(String inputResults) {
        if (inputResults.contains(WHITE_SPACE)) {
            throw new IllegalArgumentException("공백은 허용하지 않습니다.");
        }
    }

    private void validateNamesAndResultsLength(String inputNames, String inputResults) {
        String[] resultSplit = inputResults.split(COMMA_REGEX);
        String[] namesSplit = inputNames.split(COMMA_REGEX);
        if (resultSplit.length != namesSplit.length) {
            throw new IllegalArgumentException("사용자 수와 결과 수는 동일해야 합니다.");
        }
    }

    private void validateHeight(int ladderHeight) {
        if (ladderHeight <= MINIMUM_HEIGHT || MAXIMUM_HEIGHT < ladderHeight) {
            throw new IllegalArgumentException("사다리 높이 제한을 넘었습니다.");
        }
    }

    private void validateNames(String inputNames) {
        String[] split = inputNames.split(NOT_NUMERIC_AND_COMMA_REGEX);
        if (split.length != 0) {
            throw new IllegalArgumentException("문자열과 ,만 입력할 수 있습니다.");
        }
    }

    public String getInputNames() {
        return inputNames;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public String getInputResults() {
        return inputResults;
    }
}
