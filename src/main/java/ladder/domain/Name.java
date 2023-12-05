package ladder.domain;

import java.util.Objects;
import org.apache.commons.lang3.ObjectUtils;

public class Name {

    private static final int NAME_LENGTH_LIMIT = 5;
    private final String value;

    public Name(String value) {
        if (isEmptyOrNull(value)) {
            throw new IllegalArgumentException("한 글자 이상의 이름을 입력해주세요.");
        }
        validateTextLengthLimitOver(value);
        this.value = value;
    }

    private boolean isEmptyOrNull(String text) {
        return ObjectUtils.isEmpty(text);
    }

    private void validateTextLengthLimitOver(String value) {
        if (value.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 " + NAME_LENGTH_LIMIT + "자 이하만 입력가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Name)) {
            return false;
        }
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
