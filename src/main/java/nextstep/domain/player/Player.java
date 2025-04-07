package nextstep.domain.player;

import java.util.Objects;

public class Player {
    private final Name name;

    public Player(String name) {
        this.name = new Name(name);
    }

    public String getPlayerName() {
        return name.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object object) {
        if(object == this) {
            return true;
        }
        if(object == null || getClass() != object.getClass()){
            return false;
        }
        Player player = (Player) object;
        return player.name.equals(name);
    }
}
