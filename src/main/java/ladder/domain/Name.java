package ladder.domain;

import ladder.domain.exception.LadderException;

public class Name {

    public static final int NAME_SIZE = 5;
    private final String name;

    public Name(String name) {
        String trimmedName = name.trim();
        validate(trimmedName);
        this.name = trimmedName;
    }

    private void validate(String name) {
        if (!isValid(name)) {
            throw new LadderException("사람 이름은 1자 이상 5자 이하 입니다.");
        }
    }

    private static boolean isValid(String name) {
        return !name.isEmpty() && name.length() <= NAME_SIZE;
    }

    @Override
    public String toString() {
        return " ".repeat(NAME_SIZE + 1 - name.length()) + name;
    }
}
