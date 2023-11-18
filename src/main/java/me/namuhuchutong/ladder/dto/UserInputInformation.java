package me.namuhuchutong.ladder.dto;

public class UserInputInformation {

    private static final String NOT_NUMERIC_AND_COMMA_REGEX = "^[A-Za-z,]+$";
    private static final int MINIMUM_HEIGHT = 0;
    private static final int MAXIMUM_HEIGHT = 10;

    private final String inputNames;
    private final int ladderHeight;

    public UserInputInformation(String inputNames, int ladderHeight) {
        validateNames(inputNames);
        validateHeight(ladderHeight);
        this.inputNames = inputNames;
        this.ladderHeight = ladderHeight;
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
}
