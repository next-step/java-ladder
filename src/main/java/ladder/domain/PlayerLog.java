package ladder.domain;

public class PlayerLog {

    private Player player;
    private Position position;

    public PlayerLog(Player player) {
        this.player = player;
        this.position = player.getPosition();
    }

    public Player getPlayer() {
        return this.player;
    }

    public Position getPosition() {
        return this.position;
    }

}
