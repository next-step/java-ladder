package ladder.domain.result;

import ladder.domain.player.Player;

import java.util.List;
import java.util.Objects;

public class ResultPoint {
    private int startPoint;
    private int endPoint;

    public ResultPoint(int startPoint, int endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Result makeResult(List<Player> players, List<Destination> destinations) {
        Player pairPlayer = players.stream()
                .filter(player -> player.isEqualCol(startPoint))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        Destination pairDestination = destinations.stream()
                .filter(destination -> destination.isEqualCol(endPoint))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        return new Result(pairPlayer, pairDestination);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultPoint that = (ResultPoint) o;
        return startPoint == that.startPoint &&
                endPoint == that.endPoint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPoint, endPoint);
    }
}
