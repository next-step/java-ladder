package ladder.domain;

import java.util.Objects;

public class Player {

    private final Name name;

    public Player(String name){
        this(new Name(name));
    }

    public Player(Name name) {
        this.name = name;
    }

    public String name() {
        return name.toString();
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
        return name != null ? name.hashCode() : 0;
    }
}
