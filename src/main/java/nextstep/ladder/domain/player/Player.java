package nextstep.ladder.domain.player;

import java.util.Objects;

public class Player {
    private final String name;

    public Player(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[" + name + "] 참가자의 이름은 5글자를 초과할 수 없습니다.");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
