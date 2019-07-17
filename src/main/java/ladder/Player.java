package ladder;

import java.util.Objects;

public class Player {
    public static final int PLAYER_NAME_MAX_LENGTH = 5;
    private String name;

    private Player(String name) {
        if (isBlankName(name) || name.length() > PLAYER_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    private boolean isBlankName(String name) {
        return name == null || name.isEmpty();
    }

    public static Player of(String name) {
        return new Player(name);
    }

    public String getName() {
        return name;
    }

    public String getNamePad() {
        String nameAddEmpty = this.name + " ".repeat(PLAYER_NAME_MAX_LENGTH);
        return nameAddEmpty.substring(0, 6);
    }

    public boolean contain(String player) {
        return this.name.equals(player);
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
}
