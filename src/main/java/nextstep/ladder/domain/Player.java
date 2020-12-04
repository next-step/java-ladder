package nextstep.ladder.domain;

import java.util.Objects;

public class Player {
    public static final int MAX_LENGTH = 5;
    public static final String BLANK = " ";
    private final String name;

    public Player(String name) {
        name = name.replace(BLANK, "");

        checkLength(name);
        checkEmpty(name);

        this.name = name;
    }

    private void checkLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("name must not be over 5");
        }
    }

    private void checkEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name must not be empty");
        }
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

    public boolean hasName(String nameToFind) {
        return name.equals(nameToFind);
    }
}
