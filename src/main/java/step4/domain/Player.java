package step4.domain;

import step4.exception.IllegalPlayerName;

public class Player {
    public static final int NAME_MAX_SIZE = 5;

    private final String name;
    private final Position position;


    public Player(String name, Position position) {
        playerNameValidate(name);

        this.name = name;
        this.position = position;
    }

    private void playerNameValidate(String player) {
        if (player.length() > NAME_MAX_SIZE) {
            throw new IllegalPlayerName("이름이 5글자를 초과할수 없습니다.");
        }
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        if (name != null ? !name.equals(player.name) : player.name != null) return false;
        return position != null ? position.equals(player.position) : player.position == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", position=" + position.getPosition() +
                '}';
    }
}
