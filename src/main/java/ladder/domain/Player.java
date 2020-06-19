package ladder.domain;

import java.util.Objects;

public class Player {

    public static final int NAME_LIMIT = 5;

    private String name;
    private Position position;

    public Player(String name, int position) {
        nameValidate(name);
        this.name = name;
        this.position = new Position(position);
    }

    private void nameValidate(String name) {
        if (name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException("5자 이상");
        }
    }

    public String getName() {
        return this.name;
    }

    public void move(boolean beforeLine, boolean afterLine) {
        if (beforeLine) {
            position.moveLeft();
        }

        if(afterLine) {
            position.moveRight();
        }
    }

    public Position getPosition() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
