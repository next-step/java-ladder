package ladder.domain;

import java.util.Objects;

class UserName {
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    static UserName of(String name) {
        return new UserName(name);
    }

    private UserName(String name) {
        verifyBlank(name);
        verifyNameLength(name);
        this.name = name;
    }

    private void verifyBlank(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해 주세요.");
        }
    }

    private void verifyNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("이름(%s)은 최대 5글자까지 허용됩니다.", name));
        }
    }

    String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserName)) return false;
        UserName userName = (UserName) o;
        return Objects.equals(name, userName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
