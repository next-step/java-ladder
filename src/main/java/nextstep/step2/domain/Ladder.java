package nextstep.step2.domain;

import java.util.List;
import java.util.Map;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public Map<Player, Result> getGameResults() {

        return Map.of();
    }

    @Override
    public String toString() {
        return "Ladder : " + lines;
    }
}
