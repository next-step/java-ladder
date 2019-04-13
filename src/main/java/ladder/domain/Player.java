package ladder.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isEqualsName(String playerName) {
        return this.name.equals(playerName);
    }

    public boolean isEquals(Player player) {
        return this.equals(player);
    }

    public int getNameLength() {
        return this.name.length();
    }

}
