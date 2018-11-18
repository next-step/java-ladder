package domain.ladder;

import java.util.Objects;

public class Player {

    public static final int MAX_LENGTH_NAME = 5;

    private String name;

    public Player(String name) {
        if(name.length() > MAX_LENGTH_NAME){
            throw new IllegalArgumentException("플레이어는 5글자까지만 가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
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
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean findName(String playerName) {
        return this.name.equals(playerName);
    }

    public String Name() {
        return this.name;
    }
}
