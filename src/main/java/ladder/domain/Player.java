package ladder.domain;

import java.util.Objects;

public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public int max(int length) {
        if (name.length() > length) {
            return name.length();
        }

        return length;
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

        return Objects.hash(name);
    }
}
