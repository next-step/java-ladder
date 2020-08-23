package ladder.domain.core.line.name;

public class Name {
    static final String ERROR_MESSAGE_REQUIRED_NAME = "이름을 지정해 주세요.";
    static final String ERROR_MESSAGE_SUITABLE_NAME = "참여하는 사람의 이름은 알파벳(a-z), 숫자(0-9)포함 5글자 입니다.";
    static final String REGEX_SUITABLE_NAME = "[a-z][a-z0-9]{0,4}";
    private static final int MAX_LEN = 5;
    static final String ERROR_MESSAGE_MAX_LEN_NAME = String.format("지정된 이름의 최대 길이는 %d자 입니다.", MAX_LEN);
    protected final String name;

    protected Name(String name) {
        verifyBlankName(name);
        this.name = name;
    }

    static void verifyBlankName(String name) {
        if (null == name || "".equals(name.trim())) {
            throw new IllegalArgumentException(ERROR_MESSAGE_REQUIRED_NAME);
        }
    }

    String getName() {
        return name;
    }

    protected void verifySuitableName(String name) {
        if (!name.matches(REGEX_SUITABLE_NAME)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_SUITABLE_NAME);
        }
    }

    protected void verifyMaxLength() {
        if (MAX_LEN < getName().length()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MAX_LEN_NAME);
        }
    }
}
