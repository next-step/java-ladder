package ladder.domain;

import java.util.Objects;

public class Player {
    private final Name name;

    private PlayResult playResult;

    public Player(final String name) {
        this(new Name(name));
    }

    public Player(final Name name) {
        this.name = name;
    }

    public void report(final PlayResult playResult) {
        this.playResult = playResult;
    }

    public boolean isSame(Name name) {
        return Objects.equals(this.name, name);
    }

    public String getName() {
        return name.getValue();
    }

    @Override
    public String toString() {
        return name + " : " + playResult;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(playResult, player.playResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, playResult);
    }
}
