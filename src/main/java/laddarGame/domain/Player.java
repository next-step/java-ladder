package laddarGame.domain;

import laddarGame.dto.PlayerDto;

import java.util.List;
import java.util.Objects;

import static laddarGame.domain.Line.ONE;
import static laddarGame.domain.Line.ZERO;

public class Player {

    private final PlayerName playerName;
    private final Position position;

    public Player(String name, int position) {
        this.playerName = new PlayerName(name);
        this.position = new Position(position);
    }

    public Player(PlayerName playerName, Position position) {
        this.playerName = playerName;
        this.position = position;
    }

    public String playerName() {
        return playerName.name();
    }

    public Position getPosition() {
        return position;
    }


    public PlayerDto playerDto() {
        return new PlayerDto(playerName, position);
    }

    public int compare(Player otherPlayer) {
        return position.compare(otherPlayer.getPosition());
    }

    public Player move(List<Point> points, int maxPosition) {
        Position movePosition = position.move(points.get(ZERO), points.get(ONE), maxPosition);
        return new Player(this.playerName, movePosition);
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
}
