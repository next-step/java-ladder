package ladder.domain;

import ladder.utils.StringUtils;

public class Name {
    private static final String EXCEP_INVALID_NAME = "유효한 이름이 아닙니다.";
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(EXCEP_INVALID_NAME);
        }

        if (name.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(EXCEP_INVALID_NAME);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
