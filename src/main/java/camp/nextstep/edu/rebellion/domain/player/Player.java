package camp.nextstep.edu.rebellion.domain.player;

import camp.nextstep.edu.rebellion.util.StringUtil;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private final int position;

    public Player(String name, int position) {
        checkLength(name);
        this.name = name;
        this.position = position;
    }

    public boolean match(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void checkLength(String name) {
        if (StringUtil.isEmpty(name) || MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException("참가자의 이름은 최대 5글자 입니다 " + name);
        }
    }
}

