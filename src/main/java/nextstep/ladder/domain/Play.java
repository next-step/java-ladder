package nextstep.ladder.domain;

import java.util.List;

/**
 * @author han
 */
public class Play {
    private final List<Position> positions;
    private final Results results;

    public Play(List<Position> positions, Results results) {
        this.positions = positions;
        this.results = results;
    }

    public List<Position> getPosition() {
        return positions;
    }

    public Result getResults(User user) {
        Position positionByUser = positions.stream().filter(position -> position.getUser().equals(user)).findAny().orElseThrow(IllegalAccessError::new);
        return results.getResultBy(positionByUser.getIndex());
    }
}
