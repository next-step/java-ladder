package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Player {
    private final Name name;
    private final Position position;

    public Player(String name) {
        this(name, 0);
    }

    public Player(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Player movePosition(List<Boolean> points) {
        return new Player(this.name, this.position.moveBy(points));
    }

    public String getName() {
        return name.getValue();
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
