package ladder.domain.core;

class Participant {
    public static final String ERROR_MESSAGE_REQUIRED_NAME = "참여하는 사람의 이름을 지정해 주세요.";
    public static final String ERROR_MESSAGE_SUITABLE_NAME = "참여하는 사람의 이름은 알파벳(a-z), 숫자(0-9)포함 5글자 입니다.";
    public static final String REGEX_SUITABLE_NAME = "[a-z][a-z0-9]{0,4}";

    Participant(String name) {
        verifyBlankName(name);
        verifySuitableName(name);
    }

    private void verifySuitableName(String name) {
        if (!name.matches(REGEX_SUITABLE_NAME)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_SUITABLE_NAME);
        }
    }

    static void verifyBlankName(String name) {
        if (null == name || "".equals(name.trim())){
            throw new IllegalArgumentException(ERROR_MESSAGE_REQUIRED_NAME);
        }
    }
}
