package nextstep.ladder.domain.player;

import java.util.Objects;

public class Player {

    public static final int NAME_LIMIT = 5;

    private final String name;
    private int position;

    public Player(String name) {
        this(name, 0);
    }

    public Player(String name, int position) {
        if (name.isBlank() || name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException("참가자 이름은 1 ~ 5자 사이여야 합니다.");
        }

        this.name = name;
        this.position = position;
    }

    public Player copy() {
        return new Player(name, position);
    }

    public void switchPosition(Player other) {
        int temp = this.position;
        this.position = other.position;
        other.position = temp;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return position == player.position && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
