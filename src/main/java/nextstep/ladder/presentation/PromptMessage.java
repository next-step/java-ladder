package nextstep.ladder.presentation;

public enum PromptMessage {
    PARTICIPANTS_NAMES_QUESTION_MESSAGE("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
    MAXIMUM_LADDER_HEIGHT_QUESTION_MESSAGE("최대 사다리 높이는 몇 개인가요?"),
    EXECUTE_RESULT("실행결과");

    private final String message;

    PromptMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
