package game.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladders {
    private final List<Line> lines;

    public Ladders(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> lines() {
        return lines;
    }

    public List<LadderResult> findAllLadderResults(List<String> people, List<String> results) {
        List<LadderResult> ladderResults = new ArrayList<>();
        for (int startPoint = 0; startPoint < people.size(); startPoint++) {
            ladderResults.add(findOneLadderResult(people.get(startPoint), startPoint, results));
        }
        return ladderResults;
    }

    public LadderResult findOneLadderResult(String person, int startPoint, List<String> results) {
        int path = startPoint;

        for (int height = 0; height < lines().size(); height++) {
            path = lines.get(height).movePoint(path);
        }

        return new LadderResult(person, results.get(path));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladders ladders = (Ladders) o;
        return Objects.equals(lines, ladders.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
