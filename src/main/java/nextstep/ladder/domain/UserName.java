package nextstep.ladder.domain;

import java.util.Objects;
import java.util.Optional;

public class UserName {

    private static final int MAX_LENGTH = 5;

    private final String name;

    public UserName(String name) {
        assertNonEmptyName(name);
        assertValidLength(name);
        assertNotNameIsAll(name);
        this.name = name;
    }

    private void assertNonEmptyName(String name) {
        String emptyNameMessage = "[이름] 이름이 없습니다.";

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(emptyNameMessage);
        }
    }

    private void assertValidLength(String name) {
        String invalidLengthMessage = String.format("[이름] %d 글자를 초과할 수 없습니다.", MAX_LENGTH);
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(invalidLengthMessage);
        }
    }

    private void assertNotNameIsAll(String name) {
        InvalidUserName.assertNotContain(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return Objects.equals(name, userName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
