package ladder.domain.player;

import ladder.utils.StringUtils;

import java.util.Objects;

public class Player {

    private final String name;

    private Player(String name) {
        this.name = name;
    }

    public static Player of(String name) {
        StringUtils.validate(name);
        return new Player(StringUtils.getNameFrom(name));
    }

    public String getName() {
        return name;
    }

    public boolean isEqualName(String name) {
        return this.name.equals(name);
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
