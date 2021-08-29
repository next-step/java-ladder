package nextstep.ladder.domain;

public class WonderingPlayer {

    private static final String ALL = "all";

    public final String wonderingPlayer;

    public WonderingPlayer(final String wonderingPlayer) {
        this.wonderingPlayer = wonderingPlayer;
    }

    public boolean isNotAll() {
        return !wonderingPlayer.equals(ALL);
    }

    public Player getWonderingPlayer() {
        return new Player(wonderingPlayer);
    }

    @Override
    public String toString() {
        return wonderingPlayer;
    }
}
