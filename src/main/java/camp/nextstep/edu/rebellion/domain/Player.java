package camp.nextstep.edu.rebellion.domain;

import camp.nextstep.edu.rebellion.util.StringUtil;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        checkLength(name);
        this.name = name;
    }

    private void checkLength(String name) {
        if (StringUtil.isEmpty(name) || MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException("참가자의 이름은 최대 5글자 입니다 " + name);
        }
    }
}

