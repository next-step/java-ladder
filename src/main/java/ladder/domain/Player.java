package ladder.domain;

import java.util.Objects;

public class Player {

    private String name;

    public Player(String name) {
        if (nameValidate(name)) {
            throw new IllegalArgumentException("5자 이상");
        }
        this.name = name;
    }

    private boolean nameValidate(String name) {
        return name.length() > 5;
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
