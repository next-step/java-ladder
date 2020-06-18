package ladder.domain;

import java.util.Objects;

public class Player {

    public static final int NAME_LIMIT = 5;
    private String name;

    public Player(String name) {
        nameValidate(name);
        this.name = name;
    }

    private void nameValidate(String name) {
        if (name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException("5자 이상");
        }
    }

    public String getName() {
        return this.name;
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
