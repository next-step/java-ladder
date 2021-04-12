package ladder.domain;

import java.util.Objects;

public class Player {
    private final PlayerName playerName;
    private final LineNumber lineNumber;

    public Player(int number, String name) {
        lineNumber = LineNumber.valueOf(number);
        playerName = new PlayerName(name);
    }

    public PlayerName getPlayerName() {
        return playerName;
    }

    public LineNumber getLineNumber() {
        return lineNumber;
    }

    public boolean isNameEqual(PlayerName playerName) {
        return this.playerName.equals(playerName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Player player = (Player)o;
        return Objects.equals(playerName, player.playerName) && Objects.equals(lineNumber,
            player.lineNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, lineNumber);
    }
}
