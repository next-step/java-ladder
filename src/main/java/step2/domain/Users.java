package step2.domain;

import java.util.List;

public class Users {
    public static final String NAME_LENGTH_EXCEPTION = "사람의 이름은 5글자까지 가능합니다.";
    public static final int NAME_MAX_LENGTH = 5;
    public final List<String> names;

    public Users(List<String> names) {
        for (String name : names) {
            validateNames(name);
        }
        this.names = names;

    }

    private void validateNames(String name) {
        if (name.length() == 0 || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION);
        }
    }

    public int getUserCounts() {
        return this.names.size();
    }
}
