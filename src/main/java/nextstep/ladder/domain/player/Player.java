package nextstep.ladder.domain.player;

import nextstep.ladder.domain.ladder.ColumnIndex;

import java.util.Objects;

public class Player {
    private final Name name;
    private final ColumnIndex index;

    public Player(String name, int index) {
        this(new Name(name), new ColumnIndex(index));
    }

    public Player(Name name, ColumnIndex index) {
        this.name = name;
        this.index = index;
    }

    public Name name() {
        return this.name;
    }

    public ColumnIndex index() {
        return this.index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
