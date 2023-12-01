package ladder.domain;

import java.util.Objects;

public class Player {
    private static final int NAME_LENGTH_MAX = 5;
    private final String name;
    private int position;

    private Player(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    public static Player from(String name) {
        return of(name, 0);
    }

    public static Player of(String name, int position) {
        return new Player(name, position);
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 필수값입니다.");
        }

        if (name.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException("이름은 최대 5자리입니다.");
        }
    }

    public void moveLeft() {
        --position;
    }
    public void moveRight() {
        ++position;
    }

    public long length() {
        return name.length();
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
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
}
