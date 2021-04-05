package step4_ladderGame.domain;

import step4_ladderGame.dto.PlayerDto;

import java.util.Objects;

public class Player {

    private final Name name;
    private final Position position;

    private Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Player of(String name, int position) {
        return new Player(Name.of(name), Position.of(position));
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    public Player move(Position position) {
        return new Player(this.name, position);
    }

    public PlayerDto toDto() {
        return new PlayerDto(name.toString(), position.toInt());
    }
}
