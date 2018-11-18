package domain.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LadderManage {

    public static final String ALL_USER = "ALL";

    private Players players;
    private Lines lines;

    LadderManage(List<Player> playerList, List<Line> lines) {
        this.players = new Players(playerList);
        this.lines = new Lines(lines);
    }

    public Laddering play(String playerNames) {
        if(playerNames.toUpperCase().equals(ALL_USER))
            return new Laddering(players, lines);

        Player findPlayer = players.getPlayers().stream().filter(player -> player.findName(playerNames)).findFirst().orElseThrow(IllegalArgumentException::new);
        return new Laddering(new Players(Arrays.asList(findPlayer)), lines);
    }

    public Players getPlayers() {
        return players;
    }

    public Lines getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderManage that = (LadderManage) o;
        return Objects.equals(players, that.players) &&
                Objects.equals(lines, that.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players, lines);
    }
}
