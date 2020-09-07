package ladder.view;

public enum InputViewMessage {
    INPUT_FOR_NAMES("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
    INPUT_FOR_LADDER_HEIGHT("최대 사다리 높이는 몇 개인가요?");

    private final String message;

    InputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
