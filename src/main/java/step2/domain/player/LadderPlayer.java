package step2.domain.player;

public class LadderPlayer {

    private final String playerName;

    private LadderPlayer(final String playerName) {
        this.playerName = playerName;
    }

    public static void participate(final String playerName) {
        new LadderPlayer(playerName);
    }

}
