package ladder.model;

import ladder.config.NameConfig;

public class Name {
    public final static int NAME_MAX_LIMIT = NameConfig.NAME_SIZE;
    private final static int NAME_MIN_LIMIT = 1;
    private final static String NAME_LIMIT_ERROR = "올바른 이름을 입력하세요.";

    private String name;

    public Name(String name) {
        if (isNotValid(name)) {
            throw new IllegalArgumentException(NAME_LIMIT_ERROR);
        }

        this.name = name.trim();
    }

    private boolean isNotValid(String name) {
        int len = name.length();
        return len < NAME_MIN_LIMIT || NAME_MAX_LIMIT < len;
    }

    @Override
    public String toString() {
        return name;
    }
}
