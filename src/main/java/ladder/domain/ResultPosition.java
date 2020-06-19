package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class ResultPosition {

    private List<Position> resultPosition = new ArrayList<>();

    public ResultPosition(List<Position> resultPosition) {
        this.resultPosition = resultPosition;
    }

    public Position getResultPosition(Position position) {
        return resultPosition.stream()
                .filter(p -> p.equals(position))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<Position> test() {
        return resultPosition;
    }

}
