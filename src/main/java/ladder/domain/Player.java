package ladder.domain;

import org.junit.platform.commons.util.StringUtils;

public class Player {
    public static int  NAME_MAX_LENGTH = 5;
    private String name ;
    public Player(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("참여자 이름이 비어 있습니다");
        }
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("참여자 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }
    @Override
    public boolean equals(Object inputPlayer) {
        return name.equals(((Player) inputPlayer).name);
    }

    public String getName() {
        return name;
    }
}
