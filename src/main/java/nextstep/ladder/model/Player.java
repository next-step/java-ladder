package nextstep.ladder.model;

import nextstep.ladder.common.Name;

import java.util.Objects;

public class Player extends Name {

    private Index index;

    public Player(String name) {
        super(name);
        this.index = new Index(0);
    }

    public Player(String name, int index) {
        super(name);
        this.index = new Index(index);
    }

    public boolean isAdjacent(Index other) {
        return this.index.isAdjacentRight(other) || this.index.isAdjacentLeft(other);
    }

    public void move(Direction direction) {
        this.index = direction.move(index);
    }

    public Index getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Player{" +
                "index=" + index +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        if (!super.equals(o)) return false;
        Player player = (Player) o;
        return Objects.equals(getIndex(), player.getIndex());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getIndex());
    }
}
