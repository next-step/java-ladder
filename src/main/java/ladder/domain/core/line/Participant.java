package ladder.domain.core.line;

import java.util.Objects;

final class Participant extends BaseName {
    static final String ERROR_MESSAGE_SUITABLE_NAME = "참여하는 사람의 이름은 알파벳(a-z), 숫자(0-9)포함 5글자 입니다.";
    static final String REGEX_SUITABLE_NAME = "[a-z][a-z0-9]{0,4}";

    Participant(String name) {
        super(name);
        verifyBlankName(name);
        verifySuitableName(name);
    }

    private void verifySuitableName(String name) {
        if (!name.matches(REGEX_SUITABLE_NAME)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_SUITABLE_NAME);
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
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
