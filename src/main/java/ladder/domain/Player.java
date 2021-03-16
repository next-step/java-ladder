package ladder.domain;

import ladder.utils.StringUtil;

import java.util.Objects;

public class Player {

    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Player(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (StringUtil.isBlank(name)) {
            throw new IllegalArgumentException("이름이 비었습니다.");
        }
        if (MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException("이름이 5자 이상입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
