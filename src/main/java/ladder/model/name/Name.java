package ladder.model.name;

import ladder.config.Config;

public final class Name {
    private final static int NAME_MAX_LIMIT = Config.NAME_SIZE;
    private final static int NAME_MIN_LIMIT = 1;

    private final static String USER_NAME_LIMIT_ERROR = "올바른 이름을 입력하세요.";

    private final String name;

    private Name(String name, NamingConditional c) {
        if (c.condition(name.length())) {
            throw new IllegalArgumentException(USER_NAME_LIMIT_ERROR);
        }

        this.name = name.trim();
    }

    public static Name createUserName(String name){
        return new Name(name, Name::isNotUserValid);
    }

    public static Name createRewardName(String name){
        return new Name(name, Name::isNotRewardValid);
    }

    private static boolean isNotUserValid(int length) {
        return length < NAME_MIN_LIMIT || NAME_MAX_LIMIT < length;
    }

    private static boolean isNotRewardValid(int length) {
        return length < NAME_MIN_LIMIT;
    }

    @Override
    public String toString() {
        return name;
    }
}
