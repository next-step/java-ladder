package nextstep.ladder.controller;

public final class CreateLadderRequest {
    private static final int MIN_USER_SIZE = 2;
    private static final int MIN_HEIGHT_SIZE = 1;

    private final int userSize;
    private final int heightOfLadder;

    private CreateLadderRequest(int userSize, int heightOfLadder) {
        this.userSize = userSize;
        this.heightOfLadder = heightOfLadder;
    }

    public static CreateLadderRequest of(int userSize, int heightOfLadder) {
        validate(userSize, heightOfLadder);
        return new CreateLadderRequest(userSize, heightOfLadder);
    }

    public int getUserSize() {
        return userSize;
    }

    public int getHeightOfLadder() {
        return heightOfLadder;
    }

    private static void validate(int userSize, int heightOfLadder) {
        validateUserSize(userSize);
        validateHeightOfLadder(heightOfLadder);
    }

    private static void validateHeightOfLadder(int heightOfLadder) {
        if (heightOfLadder < MIN_HEIGHT_SIZE) {
            throw new IllegalArgumentException(String.format("사다리 사이즈(%d)는 %d이상이 필요합니다.", heightOfLadder, MIN_HEIGHT_SIZE));
        }
    }

    private static void validateUserSize(int userSize) {
        if (userSize < MIN_USER_SIZE) {
            throw new IllegalArgumentException(String.format("전달된 사용자의 수가 %d보다 작습니다.", MIN_USER_SIZE));
        }
    }
}
