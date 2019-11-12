package ladder.domain.result;

import ladder.domain.player.Player;

import java.util.Objects;

public class Result {
    private final Player player;
    private final Destination destination;

    public Result(Player player, Destination destination) {
        this.player = player;
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(player, result.player) &&
                Objects.equals(destination, result.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, destination);
    }
}
