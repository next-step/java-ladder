package step3.domain;

import java.util.List;

public class Users {
    private static final String NAME_LENGTH_EXCEPTION = "사람의 이름은 5글자까지 가능합니다.";
    private static final String NAME_EXCEPTION = "사람의 이름이 입력되어야 합니다.";
    private static final String NOT_CONTAINED_EXCEPTION = "사다리게임에 참여한 유저가 아닙니다";
    private static final int NAME_MAX_LENGTH = 5;

    public final List<String> names;

    public Users(List<String> names) {
        validateNames(names);
        this.names = names;

    }

    private void validateNames(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(NAME_EXCEPTION);
        }

        for (String name : names) {
            checkNameLengths(name);
        }
    }

    private void checkNameLengths(String name) {
        if (name.isBlank() || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION);
        }
    }

    public int getUserCounts() {
        return this.names.size();
    }

    public String findContainedName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NAME_EXCEPTION);
        }
        if (!name.equals("all") && !this.names.contains(name)) {
            throw new IllegalArgumentException(NOT_CONTAINED_EXCEPTION);
        }
        return name;
    }
}
