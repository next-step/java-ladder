package ladder;

import java.util.Objects;

public class Player {

    private final String name;

    public Player(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("name is too long");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Player))
            return false;
        Player that = (Player)o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public String getName() {
        return name;
    }
}
