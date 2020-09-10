package ladder.domain.player;

import ladder.util.StringUtil;
import lombok.Builder;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private final int position;

    @Builder
    private Player(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position;
    }

    public boolean matchName(String inputName) {
        return this.name.equals(inputName);
    }

    private void validateName(String name) {
        if (StringUtil.isEmpty(name) || MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 가능합니다." + name);
        }
    }
}
