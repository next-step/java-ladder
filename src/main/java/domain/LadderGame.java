package domain;

public class LadderGame {
    private PlayerNames playerNames;
    private Ladder ladder;

    private LadderGame(PlayerNames playerNames, Ladder ladder) {
        this.playerNames = playerNames;
        this.ladder = ladder;
    }

    public static LadderGame of(String names, int height) {
        PlayerNames playerNames = PlayerNames.of(names);
        Ladder ladder = Ladder.of(playerNames.size(), height);

        return new LadderGame(playerNames, ladder);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public PlayerNames getPlayerNames() {
        return playerNames;
    }
}
