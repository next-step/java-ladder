package nextstep.ladder2.domain.player;

import java.util.Objects;

public class Player {

    private String name;

    public Player(String name) {
        if (null == name || name.isBlank()) {
           throw new IllegalArgumentException("이름은 null이거나 빈값일 수 없습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5글자까지만 허용됩니다. name=[" + name + "]");
        }

        this.name = name.trim();
    }

    public String name() {
        return this.name;
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
        return Objects.hash(name);
    }
}
