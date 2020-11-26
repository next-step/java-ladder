package domain;

import exception.NegativeLengthException;

public class LadderGame {
    private PlayerNames playerNames;
    private Ladder ladder;

    private LadderGame(PlayerNames playerNames, Ladder ladder) {
        this.playerNames = playerNames;
        this.ladder = ladder;
    }

    public static LadderGame of(PlayerNames playerNames, Length height) throws NegativeLengthException {
        Length width = Length.of(playerNames.size());
        Ladder ladder = Ladder.of(width, height);

        return new LadderGame(playerNames, ladder);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public PlayerNames getPlayerNames() {
        return playerNames;
    }
}
