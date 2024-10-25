package ladder;

import java.util.Objects;

public class PlayerOld {

    private final String name;

    public PlayerOld(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("name is too long");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof PlayerOld))
            return false;
        PlayerOld that = (PlayerOld)o;
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
