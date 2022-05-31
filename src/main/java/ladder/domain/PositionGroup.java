package ladder.domain;

import ladder.exception.NotFoundResultException;

import java.util.List;
import java.util.stream.Collectors;

public class PositionGroup {

    private final Positions playerPositions;
    private final Positions resultPositions;

    public PositionGroup(Positions playerPositions, Positions resultPositions) {
        if (playerPositions == null || resultPositions == null) {
            throw new IllegalArgumentException();
        }
        this.playerPositions = playerPositions;
        this.resultPositions = resultPositions;
    }

    public int maxNameSize() {
        int playersMaxNameSize = playerPositions.maxNameSize();
        int resultsMaxNameSize = resultPositions.maxNameSize();
        return Integer.max(playersMaxNameSize, resultsMaxNameSize);
    }

    public Positions playerPositions() {
        return playerPositions;
    }

    public Positions resultPositions() {
        return resultPositions;
    }

    public Result result(Name name) {
        if (playerPositions.containUnfixedPosition()) {
            throw new NotFoundResultException();
        }
        Position playerPosition = playerPositions.value(name);
        return new Result(playerPosition.name(), resultPositions.value(playerPosition.index()));
    }

    public List<Result> resultAll() {
        return playerPositions.toList()
                .stream()
                .map(Position::name)
                .map(name -> result(name))
                .collect(Collectors.toList());
    }
}
