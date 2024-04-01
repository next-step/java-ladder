package nextstep.ladder.domain;

import java.util.Optional;

public class UserName {
    private final String name;
    private static final int MAX_LENGTH = 5;


    public UserName(String name) {
        assertNonEmptyName(name);
        assertValidLength(name);
        this.name = name;
    }

    public UserName(UserName userName) {
        this.name = userName.name;
    }

    private void assertValidLength(String name) {
        String invalidLengthMessage = String.format("[이름] %d 글자를 초과할 수 없습니다.", MAX_LENGTH);
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(invalidLengthMessage);
        }
    }

    private void assertNonEmptyName(String name) {
        String emptyNameMessage = "[이름] 이름이 없습니다.";

        Optional.ofNullable(name)
                .filter(input -> !input.isBlank())
                .orElseThrow(() -> new IllegalArgumentException(emptyNameMessage));
    }

    public String getName() {
        return name;
    }
}
