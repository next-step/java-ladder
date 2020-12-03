package nextstep.ladder.domain;

import java.util.Objects;

public class PlayersOnLine {

    private final Players players;

    public PlayersOnLine(Players players) {
        this.players = new Players(players.getPlayers());
    }

    public void swapWithNext(int position) {
        players.swapWithNext(position);
    }

    public Players getPlayers() {
        return players;
    }

    public Player get(int index) {
        return players.getPlayers().get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayersOnLine that = (PlayersOnLine) o;
        return Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
