package ladder.domain;

import ladder.util.StringUtil;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    private Player(String name) {
        validateName(name);
        this.name = name;
    }

    public static Player of(String name) {
        return new Player(name);
    }

    public String getName() {
        return this.name;
    }

    private void validateName(String name) {
        if (StringUtil.isEmpty(name) || MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 가능합니다." + name);
        }
    }
}
