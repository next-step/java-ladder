package me.namuhuchutong.ladder;

public class UserInputInformation {

    private final String inputNames;
    private final int ladderHeight;

    public UserInputInformation(String inputNames, int ladderHeight) {
        validateNames(inputNames);
        validateHeight(ladderHeight);
        this.inputNames = inputNames;
        this.ladderHeight = ladderHeight;
    }

    private void validateHeight(int ladderHeight) {
        if (ladderHeight <= 0 || 10 < ladderHeight) {
            throw new IllegalArgumentException("사다리 높이는 1~10 사이 입니다.");
        }
    }

    private void validateNames(String inputNames) {
        String[] split = inputNames.split("^[A-Za-z,]+$");
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
