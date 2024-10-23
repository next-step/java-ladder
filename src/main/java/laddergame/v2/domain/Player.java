package laddergame.v2.domain;

import java.util.Objects;

public class Player {
    private static final int NAME_LIMIT = 5;

    private final String name;

    public Player(String name) {
        if(name.length() > NAME_LIMIT){
            throw new IllegalArgumentException(String.format("플레이어의 이름을 %d자 이하로 입력해주세요.", NAME_LIMIT));
        }
        this.name = name;
    }

    public String getName() {
        return name;
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
        return Objects.hashCode(name);
    }
}
