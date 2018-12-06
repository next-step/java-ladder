package net.chandol.ladder.v2.domain.player;

import net.chandol.ladder.v2.support.StringUtils;

import java.util.Objects;

import static net.chandol.ladder.v2.support.Constants.PLAYER_MAX_LENGTH;

public class Player {
    private String name;

    public Player(String name) {
        StringUtils.validateString(name, PLAYER_MAX_LENGTH);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNameWithFixedLength(){
        return StringUtils.toFixedLength(name, PLAYER_MAX_LENGTH);
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

    public static Player player(String name){
        return new Player(name);
    }
}
