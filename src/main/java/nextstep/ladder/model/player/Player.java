package nextstep.ladder.model.player;

import java.util.Objects;

public class Player {
    private final String name;
    
    public Player(final String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public boolean equals(final Object o) {
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
