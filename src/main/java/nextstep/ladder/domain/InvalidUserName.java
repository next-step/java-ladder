package nextstep.ladder.domain;

import java.util.Arrays;

public enum InvalidUserName {
    ALL("all");

    private final String invalidName;

    InvalidUserName(String invalidName) {
        this.invalidName = invalidName;
    }

    public static void assertNotContain(String name) {
        String errorMessage = "[이름] 올바르지 않은 이름입니다.";
        Arrays.stream(InvalidUserName.values())
                .filter(invalidUserName -> invalidUserName.invalidName.equalsIgnoreCase(name))
                .findAny()
                .ifPresent(data -> {
                    throw new IllegalArgumentException(errorMessage);
                });
    }

    public String getInvalidName() {
        return invalidName;
    }
}
