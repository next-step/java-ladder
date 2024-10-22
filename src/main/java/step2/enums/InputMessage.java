package step2.enums;

public enum InputMessage {

    INPUT_PERSON("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
    INPUT_MAX_LADDER("최대 사다리 높이는 몇 개인가요?"),
    INPUT_LADDER_PRIZE("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)"),
    INPUT_CHOOSE_PERSON("결과를 보고 싶은 사람은?");

    InputMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String message() {
        return message;
    }

}
