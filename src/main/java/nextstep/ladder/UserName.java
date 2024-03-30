package nextstep.ladder;

import java.util.Optional;

public class UserName {
    private final String name;


    public UserName(String name) {
        assertNonEmptyName(name);
        assertValidLength(name);
        this.name = name;
    }

    public UserName(UserName userName) {
        this.name = userName.name;
    }

    private void assertValidLength(String name) {
        String invalidLengthMessage = "[이름] 5글자를 초과할 수 없습니다.";
        if (name.length() > 5) {
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
