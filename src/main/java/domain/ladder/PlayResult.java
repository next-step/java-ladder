package domain.ladder;

import java.util.Objects;

public class PlayResult {
    private final Player player;
    private final String result;

    public PlayResult(Player player, String result) {
        this.player = player;
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayResult that = (PlayResult) o;
        return Objects.equals(player, that.player) &&
                Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, result);
    }

    @Override
    public String toString() {
        return player +
                " : " + result;
    }
}
