package ladder.context;

public enum PrintMessage {
    GAME_PLAYER("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
    LADDER_SIZE("최대 사다리 높이는 몇 개인가요?"),
    RESULT_PLAYER("결과를 보고 싶은 사람은?"),
    INIT_PRODUCTS("실행 결과를 입력하세요 (결과는 쉼(,)로 구분하세요)");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
