package ladder.domain.result;

import ladder.domain.player.Player;

import java.util.List;
import java.util.stream.Collectors;

public class ResultPoints {
    private List<ResultPoint> resultPoints;

    public ResultPoints(List<ResultPoint> resultPoints) {
        this.resultPoints = resultPoints;
    }

    public Results makeResults(List<Player> players, List<Destination> destinations) {
        List<Result> results = this.resultPoints.stream()
                .map(resultPoint -> resultPoint.makeResult(players, destinations))
                .collect(Collectors.toList());
        return new Results(results);
    }
}
