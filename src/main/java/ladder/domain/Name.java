package ladder.domain;

import ladder.domain.exception.LadderException;

public class Name {

    public static final int NAME_SIZE = 5;
    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value.trim();
    }

    private void validate(String value) {
        if (!isValid(value)) {
            throw new LadderException("사람 이름은 1자 이상 5자 이하 입니다.");
        }
    }

    private static boolean isValid(String value) {
        return !value.isEmpty() && value.length() <= NAME_SIZE;
    }

    @Override
    public String toString() {
        return " ".repeat(NAME_SIZE + 1 - value.length()) + value;
    }
}
