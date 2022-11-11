package game.domain.ladder;

import java.util.ArrayList;
import java.util.List;

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
            int left = path > 0 ? path - 1 : -1;
            int right = path;

            if (left >= 0 && lines().get(height).points().get(left)) {
                path -= 1;
            }

            if (right < lines().get(0).points().size() && lines().get(height).points().get(right)) {
                path += 1;
            }
        }

        return new LadderResult(person, results.get(path));
    }
}
