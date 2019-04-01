package domain.player;

import java.util.Objects;

public class Player {

    public static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Player(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    public String beautify() {
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
