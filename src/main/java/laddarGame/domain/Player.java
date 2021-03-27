package laddarGame.domain;

import laddarGame.dto.PlayerDto;

import java.util.Objects;

public class Player {

    private final PlayerName playerName;
    private final Position position;

    public Player(String name, int position) {
        this.playerName = new PlayerName(name);
        this.position = new Position(position);
    }

    public String playerName() {
        return playerName.name();
    }

    public Position getPosition() {
        return position;
    }

    public void rightMove() {
        position.rightMove();
    }

    public void leftMove() {
        position.leftMove();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerName, player.playerName) && Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, position);
    }

    public PlayerDto playerDto() {
        return new PlayerDto(playerName, position);
    }

    public int compare(Player player2) {
        return position.compare(player2.getPosition());
    }
}
