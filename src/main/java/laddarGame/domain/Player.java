package laddarGame.domain;

import java.util.Objects;

public class Player {

    private Name name;
    private Position position;

    public Player(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
    

}
