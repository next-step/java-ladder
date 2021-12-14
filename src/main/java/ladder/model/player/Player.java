package ladder.model.player;

import ladder.model.name.Name;

import java.util.Objects;

public class Player {

    private final Name name;

    public Player(Name name) {
        this.name = name;
    }

    public Player(String name) {
        this.name = new Name(name);
    }

    public String name() {
        return name.get();
    }

    public boolean isName(String name) {
        return this.name.equals(new Name(name));
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
