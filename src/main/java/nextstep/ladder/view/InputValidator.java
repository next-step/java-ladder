package nextstep.ladder.view;

public class InputValidator {

    public void validatePlayerName(String input, String delimiter) {
        validateNone(input);
        validateNumOfPlayers(input, delimiter);
    }

    private void validateNone(String input) {
        if (isNone(input)) {
            throw new IllegalArgumentException("이름은 빈 문자열이 될 수 없습니다.");
        }
    }

    private boolean isNone(String input) {
        return input.isEmpty() || input.isBlank();
    }

    private void validateNumOfPlayers(String input, String delimiter) {
        if (hasNotDelimiter(input, delimiter)) {
            throw new IllegalArgumentException("사다리 게임엔 2명 이상의 플레이어가 필요합니다.");
        }
    }

    private boolean hasNotDelimiter(String input, String delimiter) {
        return !input.contains(delimiter);
    }

    public void validateHeight(String input) {
        int height = validateParseInteger(input);
        validateNegative(height);
    }

    private int validateParseInteger(String input) {
        int height;

        try {
            height = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 정수만 입력 가능합니다.");
        }

        return height;
    }

    private void validateNegative(int height) {
        if (isNotPositive(height)) {
            throw new IllegalArgumentException("사다리 높이는 양의 정수만 입력 가능합니다.");
        }
    }

    private boolean isNotPositive(int height) {
        return height <= 0;
    }

    public void validatePrizes(String input, String delimiter, int numOfPlayers) {
        validateNone(input);
        validateNumOfPrizes(input, delimiter, numOfPlayers);
    }

    private void validateNumOfPrizes(String input, String delimiter, int numOfPlayers) {
        if (hasNotDelimiter(input, delimiter)) {
            throw new IllegalArgumentException("상품 개수는 플레이어 수와 같아야 합니다.");
        }

        String[] split = input.split(delimiter);
        if (numOfPlayers != split.length) {
            throw new IllegalArgumentException("상품 개수는 플레이어 수와 같아야 합니다.");
        }
    }
}
