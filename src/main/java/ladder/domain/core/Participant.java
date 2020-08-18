package ladder.domain.core;

import java.util.Objects;

class Participant {
    public static final String ERROR_MESSAGE_REQUIRED_NAME = "참여하는 사람의 이름을 지정해 주세요.";
    public static final String ERROR_MESSAGE_SUITABLE_NAME = "참여하는 사람의 이름은 알파벳(a-z), 숫자(0-9)포함 5글자 입니다.";
    public static final String REGEX_SUITABLE_NAME = "[a-z][a-z0-9]{0,4}";
    private final String name;

    Participant(String name) {
        verifyBlankName(name);
        verifySuitableName(name);
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
