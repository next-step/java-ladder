package ladder.domain;

import java.util.Objects;

public class Player {
    private final PlayerName playerName;
    private final LineNumber lineNumber;

    public Player(String name, int number) {
        lineNumber = new LineNumber(number);
        playerName = new PlayerName(name);
    }

    public PlayerName getNames() {
        return playerName;
    }

    public LineNumber getLineNumber() {
        return lineNumber;
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
